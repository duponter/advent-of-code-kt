package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.mapIndexed
import be.edu.adventofcode.grid.transpose

class Day08 {
    fun part1(input: Lines): Int {
        val forest: Matrix<Tree> = buildForest(input)
        val transposedForest = forest.transpose()

        return forest.flatten().size - forest.flatten().count { it.hiddenHorizontally(forest) && it.hiddenVertically(transposedForest) }
    }

    fun part2(input: Lines): Int {
        val forest: Matrix<Tree> = buildForest(input)
        val transposedForest = forest.transpose()

        return forest.flatten().maxOf { it.scenicScoreHorizontally(forest) * it.scenicScoreVertically(transposedForest) }
    }

    private fun buildForest(input: Lines): Matrix<Tree> {
        return input.get()
            .map { it.asIterable().map { c -> c.digitToInt() } }
            .mapIndexed { x, y, value -> Tree(x, y, value) }
    }

    data class Tree(val x: Int, val y: Int, val value: Int) {
        fun hiddenHorizontally(forest: Matrix<Tree>): Boolean = hidden(forest, x, y)

        fun hiddenVertically(forest: Matrix<Tree>): Boolean = hidden(forest, y, x)

        private fun hidden(forest: Matrix<Tree>, row: Int, col: Int): Boolean {
            val before = forest[row].take(col)
            val after = forest[row].drop(col + 1)
            return before.isNotEmpty() && before.any { it.value >= value }
                    && after.isNotEmpty() && after.any { it.value >= value }
        }

        fun scenicScoreHorizontally(forest: Matrix<Tree>): Int = scenicScore(forest, x, y)

        fun scenicScoreVertically(forest: Matrix<Tree>): Int = scenicScore(forest, y, x)

        private fun scenicScore(forest: Matrix<Tree>, row: Int, col: Int): Int {
            val before = forest[row].take(col).reversed()
            val beforeBlocked = before.takeWhile { it.value < value }
            var scoreLeft = beforeBlocked.size
            if (before.size > beforeBlocked.size) scoreLeft += 1

            val after = forest[row].drop(col + 1)
            val afterBlocked = after.takeWhile { it.value < value }
            var scoreRight = afterBlocked.size
            if (after.size > afterBlocked.size) scoreRight += 1

            return scoreLeft * scoreRight
        }
    }
}
