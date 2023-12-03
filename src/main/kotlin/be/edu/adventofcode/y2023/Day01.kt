package be.edu.adventofcode.y2023

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return input.get().sumOf {
            it.toCharArray().filter { c -> c.isDigit() }.let { d -> d.first().digitToInt() * 10 + d.last().digitToInt() }
        }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}
