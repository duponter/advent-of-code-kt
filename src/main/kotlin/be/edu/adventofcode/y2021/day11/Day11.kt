package be.edu.adventofcode.y2021.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.map
import be.edu.adventofcode.grid.mapIndexed

class Day11 {
    fun part1(input: Lines, steps: Int = 100): Int {
        var matrix: Matrix<Int> = input.get().map { line -> line.map { it.digitToInt() } }
        var flashCount = 0
        for (i in 1..steps) {
            matrix = matrix.map { it + 1 }

            do {
                val toFlash: List<Pair<Int, Int>> = matrix.mapIndexed { row, col, value -> if (value > 9) row to col else null }.flatten().filterNotNull()
                matrix = toFlash.fold(matrix) { m, pair -> flash(m, pair.first, pair.second) }
            } while (toFlash.isNotEmpty())
            flashCount += matrix.sumOf { it.count { value -> value == 0 } }
        }

        return flashCount
    }

    private fun flash(matrix: Matrix<Int>, row: Int, col: Int): Matrix<Int> {
        val rowRange: IntRange = row - 1..row + 1
        val colRange: IntRange = col - 1..col + 1
        return matrix.mapIndexed { r, c, value -> if ((row == r && col == c) || value == 0) 0 else if (r in rowRange && c in colRange) value + 1 else value }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
