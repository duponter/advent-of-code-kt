package be.edu.adventofcode.y2017.day02

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
                .map { stringToDifference(it) }
                .sum()
    }

    private fun stringToDifference(input: String): Int {
        val values = input.split(Regex("\\s+")).map(String::toInt)
        return values.max()!! - values.min()!!
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
