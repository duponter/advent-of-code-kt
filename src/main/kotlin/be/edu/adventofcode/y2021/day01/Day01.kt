package be.edu.adventofcode.y2021.day01

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { it.toInt() }
            .zipWithNext { f, s -> if (s > f) 1 else 0 }
            .sum()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
