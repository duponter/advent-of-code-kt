package be.edu.adventofcode.y2019.day01

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return calculateFuel(input.get()
                .map { it.toInt() })
    }

    private fun calculateFuel(modules: List<Int>): Int {
        return modules.map { it.div(3) }
                .map { it - 2 }
                .sum()
    }

	fun part2(input: Lines): Int {
        return input.get()
                .map { it.toInt() }
                .map { calculateFuel(listOf(it)) }
                .map { includeAddedFuel(it) }
                .sum()
    }

	private fun includeAddedFuel(input: Int): Int {
        return generateSequence(input, { calculateFuel(listOf(it)) })
                .takeWhile { it > 0 }
                .sum()
    }
}
