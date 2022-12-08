package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.mapIndexed
import be.edu.adventofcode.grid.transpose

class Day08 {
    fun part1(input: Lines): Int {
        val forest: Matrix<Point> = input.get()
            .map { it.asIterable().map { c -> c.digitToInt() } }
            .mapIndexed { x, y, value -> Point(x, y, value) }
        val transposedForest = forest.transpose()

        return forest.flatten().size - forest.flatten().count { it.hiddenHorizontally(forest) && it.hiddenVertically(transposedForest) }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}

data class Point(val x: Int, val y: Int, val value: Int) {
    fun hiddenHorizontally(forest: Matrix<Point>): Boolean = hidden(forest, x, y)

    fun hiddenVertically(forest: Matrix<Point>): Boolean = hidden(forest, y, x)

    private fun hidden(forest: Matrix<Point>, row: Int, col: Int): Boolean {
        val before = forest[row].take(col)
        val after = forest[row].drop(col + 1)
        return before.isNotEmpty() && before.any { it.value >= value }
                && after.isNotEmpty() && after.any { it.value >= value }
    }
}
