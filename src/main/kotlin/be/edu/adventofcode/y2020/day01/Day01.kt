package be.edu.adventofcode.y2020.day01

import be.edu.adventofcode.Lines
import be.edu.adventofcode.calculations.CartesianProduct

class Day01 {
    fun part1(input: Lines): Int {
        val entries: List<Int> = input.get().map { it.toInt() }
        return CartesianProduct.pair(entries, entries)
                .first { it.first + it.second == 2020 }
                .let { it.first * it.second }
    }

    fun part2(input: Lines): Int {
        val entries: List<Int> = input.get().map { it.toInt() }
        return CartesianProduct.triple(entries, entries, entries)
                .first { it.first + it.second + it.third == 2020 }
                .let { it.first * it.second * it.third }
    }
}
