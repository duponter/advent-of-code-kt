package be.edu.adventofcode.y2020

import be.edu.adventofcode.Lines
import be.edu.adventofcode.calculations.CartesianProduct

class Day09 {
    fun part1(input: Lines, preambleLength: Int): Long {
        return input.get()
            .map { it.toLong() }
            .windowed(preambleLength + 1)
            .first { !isValid(it) }
            .last()
    }

    private fun isValid(numbers: List<Long>): Boolean {
        val preamble = numbers.dropLast(1)
        return CartesianProduct.pair(preamble, preamble)
            .filter { it.first != it.second }
            .map { it.first + it.second }
            .contains(numbers.last())
    }

    fun part2(input: Lines, preambleLength: Int): Long {
        val invalidNumber = this.part1(input, preambleLength)
        val numbers = input.get().map { it.toLong() }.dropLastWhile { it > invalidNumber }

        var maxSize = 0
        for (setSize in 2 until numbers.size) {
            if (numbers.windowed(setSize).firstOrNull { it.sum() == invalidNumber } != null) {
                maxSize = setSize
            }
        }
        return numbers.windowed(maxSize)
            .first { it.sum() == invalidNumber }
            .let { it.minOrNull()!! + it.maxOrNull()!! }
    }
}
