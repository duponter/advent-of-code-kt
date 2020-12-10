package be.edu.adventofcode.y2020.day10

import be.edu.adventofcode.Lines

class Day10 {
    fun part1(input: Lines): Int {
        val outputJoltages = input.get().map { it.toInt() }
        val joltDifferenceCount: Map<Int, Int> = (listOf(0, outputJoltages.maxOrNull()!! + 3) + outputJoltages)
            .sorted()
            .windowed(2)
            .map { it[1] - it[0] }
            .groupingBy { it }
            .eachCount()

        return joltDifferenceCount[1]!! * joltDifferenceCount[3]!!
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
