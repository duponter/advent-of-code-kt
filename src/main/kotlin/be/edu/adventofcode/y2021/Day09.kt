package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.transpose

class Day09 {
    fun part1(input: Lines): Int {
        val rows = lowPoints(toMatrix(input.get()))
        val cols = lowPoints(toMatrix(input.get()).transpose()).transpose()
        val lowPoints = rows.zip(cols) { r, c -> r.zip(c) }.flatMap { it.map { pair -> if (pair.first == pair.second) pair.first else -1 } }
        return lowPoints.sumOf { it + 1 }
    }

    private fun toMatrix(lines: List<String>): Matrix<Int> = lines.map { it.map { c -> c.digitToInt() } }

    private fun lowPoints(matrix: Matrix<Int>): Matrix<Int> {
        return matrix.map { listOf(9).plus(it).plus(9) }
            .map { it.windowed(3, 1, true).dropLast(2) }
            .map { line -> line.map { lowPoints(it) } }
    }

    private fun lowPoints(heights: List<Int>): Int {
        return if (heights[1] < heights[0] && heights[1] < heights[2]) heights[1] else -1
    }

    fun part2(input: Lines): Int {
        val matrix = toMatrix(input.get())
        val rows = lowPoints(matrix)
        val cols = lowPoints(matrix.transpose()).transpose()
        val lowPoints = rows.zip(cols) { r, c -> r.zip(c) }
            .map { line -> line.mapIndexed { idx, pair -> idx to if (pair.first == pair.second) pair.first else -1 } }
            .flatMapIndexed { idx, line -> line.filter { pair -> pair.second > -1 }.map { pair -> idx to pair } }
            .map { LowPoint(it.first, it.second.first, it.second.second) }

        val basinSizes: List<Basin> = lowPoints.map { Basin(listOf(it)) }.map { basin -> basin.expand(matrix) }.sortedByDescending { it.size() }
        return basinSizes.take(3).fold(1) { acc, next -> acc * next.size() }
    }

    fun part2alt(input: Lines): Int {
        val matrix: Matrix<LowPoint> = toMatrix(input.get())
            .mapIndexed { rowIdx, row -> row.mapIndexed { colIdx, value -> LowPoint(rowIdx, colIdx, value) } }

        val horizontalBasins: List<List<Basin>> = matrix.map { splitOn9(it) }.map { row -> row.flatMap { it.split() } }
        val verticalBasins: List<List<Basin>> = matrix.transpose()
            .map { row -> row.map { it.transpose() } }
            .map { splitOn9(it) }
            .map { row -> row.flatMap { it.split() }.map { Basin(it.points.map { pt -> pt.transpose() }) } }

        var allBasins = horizontalBasins.flatten().plus(verticalBasins.flatten())
        while (true) {
            val merged = mergeBasins(allBasins)
            if (merged.size == allBasins.size) {
                break
            }
            allBasins = merged
        }

        return allBasins.sortedByDescending { it.size() }.take(3).fold(1) { acc, next -> acc * next.size() }
    }

    private fun splitOn9(line: List<LowPoint>): List<Basin> {
        val nines: List<LowPoint> = line.filter { it.value == 9 }
        val chunked: List<List<LowPoint>> = nines.windowed(2) { line.subList(it.first().col + 1, it.last().col) }
        return listOf(line.take(nines.first().col))
            .plus(chunked)
            .plus(listOf(line.drop(nines.last().col + 1)))
            .filterNot { it.isEmpty() }
            .map { Basin(it) }
    }

    private fun mergeBasins(basins: List<Basin>): List<Basin> {
        val basinsPerPoint: MutableMap<LowPoint, Basin> = basins.flatMap { it.points }.distinct()
            .map { it to basins.filter { basin -> basin.points.contains(it) } }
            .associate { it.first to Basin.mergeAll(it.second) }
            .toMutableMap()

        return groupOverlapping(
            basinsPerPoint.values.sortedBy { it.size() }
                .map { Basin.mergeAll(it.points.mapNotNull { pt -> basinsPerPoint.remove(pt) }) }
                .filter { it.size() > 0 }
        )
    }

    private fun groupOverlapping(basins: List<Basin>): List<Basin> {
        val overlappingBasins = basins.sortedBy { it.size() }.filter { it.overlap(basins.first()) }.toSet()
        val remainder = basins.minus(overlappingBasins)
        val merged = listOf(Basin.mergeAll(overlappingBasins))
        return if (remainder.isEmpty()) merged else merged.plus(groupOverlapping(remainder))
    }
}

data class LowPoint(val row: Int, val col: Int, val value: Int) {
    fun transpose(): LowPoint = LowPoint(col, row, value)
}

data class Basin(val points: List<LowPoint>) {
    companion object {
        fun mergeAll(basins: Iterable<Basin>): Basin = Basin(basins.flatMap { it.points }.distinct())
    }

    fun size(): Int = points.size

    fun overlap(other: Basin) = other.points.any { this.points.contains(it) }

    fun split(): List<Basin> {
        if (size() == 1) {
            return listOf(this)
        }
        val selected: MutableList<MutableList<LowPoint>> = mutableListOf(mutableListOf(points.first()))
        var desc = true
        for (point in points.drop(1)) {
            val prev = selected.last().last()
            if (point.col == prev.col + 1) {
                when (point.value) {
                    prev.value + 1 -> {
                        selected.last().add(point)
                        desc = false
                    }
                    prev.value - 1 -> {
                        if (desc) {
                            selected.last().add(point)
                        } else {
                            selected.add(mutableListOf(point))
                            desc = true
                        }
                    }
                    else -> {
                        selected.add(mutableListOf(point))
                        desc = true
                    }
                }
            } else {
                selected.add(mutableListOf(point))
                desc = true
            }
        }
        return selected.map { Basin(it.toList()) }
    }

    fun expand(matrix: Matrix<Int>): Basin = this.expand(matrix, matrix.transpose())

    private fun expand(matrix: Matrix<Int>, invMatrix: Matrix<Int>): Basin {
        val expanded = this.expandOnce(matrix, invMatrix)
        return if (expanded.size() == this.size()) this else expanded.expand(matrix, invMatrix)
    }

    private fun expandOnce(matrix: Matrix<Int>, invMatrix: Matrix<Int>): Basin {
        val horizontallyExpanded: List<LowPoint> = this.expandHorizontally(matrix).distinct()
        val verticallyExpanded: List<LowPoint> = Basin(horizontallyExpanded.map { it.transpose() }).expandHorizontally(invMatrix).map { it.transpose() }.distinct()
        return if (this.size() == verticallyExpanded.size) this else Basin(verticallyExpanded)
    }

    private fun expandHorizontally(matrix: Matrix<Int>): List<LowPoint> = points.flatMap { upperLevels(matrix[it.row], it) }

    private fun upperLevels(row: List<Int>, point: LowPoint): List<LowPoint> =
        (point.col downTo 0).takeWhile { row[it] == point.value + (point.col - it) }
            .plus((point.col until row.size).takeWhile { row[it] == point.value + (it - point.col) })
            .map { LowPoint(point.row, it, row[it]) }
            .filterNot { it.value == 9 }
}


