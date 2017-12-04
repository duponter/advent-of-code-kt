package be.edu.adventofcode.y2017.day04

import be.edu.adventofcode.Lines

class Day04 {
    fun part1(input: Lines): Int = input.get().map { it.split(Regex("\\s+")).groupBy({ it }).any { it.value.size > 1 } }.count { !it }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
