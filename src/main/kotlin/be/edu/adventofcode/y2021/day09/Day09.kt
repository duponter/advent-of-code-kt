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
        return input.get().count()
    }
}
