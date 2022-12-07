package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return countIncreases(input.get().map { it.toInt() })
    }

    fun part2(input: Lines): Int {
        return countIncreases(input.get()
            .map { it.toInt() }
            .windowed(3, 1, false) { it.sum() }
        )
    }

    private fun countIncreases(measurements: List<Int>): Int {
        return measurements
            .zipWithNext { f, s -> if (s > f) 1 else 0 }
            .sum()
    }
}
