package be.edu.adventofcode.y2021.day09

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.transpose

class Day09 {
    fun part1(input: Lines): Int {
        val rows = lowPoints(toMatrix(input.get()))
        val cols = lowPoints(toMatrix(input.get()).transpose()).transpose()
        return rows.zip(cols) { r, c -> r.zip(c) }
            .flatMap { it.map { pair -> if (pair.first == pair.second) pair.first else -1 } }
            .sumOf { it + 1 }
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

        val basinSizes: List<Pair<Int, Int>> = lowPoints.map { Basin(listOf(it)) }
            .mapIndexed { idx, basin -> idx to basin.expand(matrix).size() }
            .sortedByDescending { it.second }
        println(basinSizes)
        return basinSizes.take(3).fold(1) { acc, next -> acc * next.second }
    }
}

data class LowPoint(val row: Int, val col: Int, val value: Int) {
    fun transpose(): LowPoint = LowPoint(col, row, value)
}

data class Basin(val points: List<LowPoint>) {
    fun size(): Int = points.size

    fun expand(matrix: Matrix<Int>): Basin = generateSequence(this to true) { pair -> expandStop(pair, matrix) }.takeWhile { pair -> pair.second }.last().first

    private fun expandStop(basin: Pair<Basin, Boolean>, matrix: Matrix<Int>): Pair<Basin, Boolean> {
        val expanded = basin.first.expandOnce(matrix)
        return expanded to (expanded.size() > basin.first.size())
    }

    private fun expandOnce(matrix: Matrix<Int>): Basin = Basin(
        this.expandHorizontally(matrix)
            .plus(Basin(points.map { it.transpose() }).expandHorizontally(matrix.transpose()).map { it.transpose() })
            .distinct()
    )

    private fun expandHorizontally(matrix: Matrix<Int>): List<LowPoint> = points.flatMap { upperLevels(matrix[it.row], it) }

    private fun upperLevels(row: List<Int>, point: LowPoint): List<LowPoint> {
        var expand = listOf(point)
        if (point.value < 8) {
            if (point.col != 0 && row[point.col - 1] == point.value + 1) {
                expand = expand.plus(LowPoint(point.row, point.col - 1, row[point.col - 1]))
            }
            if (point.col != row.size - 1 && row[point.col + 1] == point.value + 1) {
                expand = expand.plus(LowPoint(point.row, point.col + 1, row[point.col + 1]))
            }
        }
        return expand
    }
}


