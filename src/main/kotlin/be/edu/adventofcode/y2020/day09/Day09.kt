package be.edu.adventofcode.y2020.day09

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
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

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
