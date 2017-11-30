package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.Text

class Day12 {
    fun part1(input: Text): Int = Regex("(-?\\d+)").findAll(input.get())
            .map { it.value.toInt() }
            .sum()

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
