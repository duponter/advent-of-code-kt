package be.edu.adventofcode.y2020.day06

import be.edu.adventofcode.Text

class Day06 {
    fun part1(input: Text): Int {
        return input.get().split("\n\n")
            .map { it.filter { ch -> ch != '\n' } }
            .map { it.chars().distinct().count() }
            .sum().toInt()
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
