package be.edu.adventofcode.y2021.day09

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.transpose

class Day09 {
    fun part1(input: Lines): Int {
        val rows = lowPoints(toMatrix(input.get()))
        val cols = lowPoints(toMatrix(input.get()).transpose()).transpose()
        val lowPoints = rows.zip(cols) { r, c -> r.zip(c) }.flatMap { it.map { pair -> if (pair.first == pair.second) pair.first else -1 } }
        println("part 1 - lowpoints found: ${lowPoints.filterNot { it == -1 }.size}")
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
}

data class LowPoint(val row: Int, val col: Int, val value: Int) {
    fun transpose(): LowPoint = LowPoint(col, row, value)
}

data class Basin(val points: List<LowPoint>) {
    fun size(): Int = points.size

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


