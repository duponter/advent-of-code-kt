package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import kotlin.math.abs

class Day01 {
    fun part1(input: Lines): Int {
        val tokens = input.get().map { StringDestructure("^(\\d+)\\s+(\\d+)\$").pair(it) }
        return tokens.map { it.first.toInt() }.sorted()
            .zip(tokens.map { it.second.toInt() }.sorted()) { f, s -> abs(f - s) }
            .sum()
    }

    fun part2(input: Lines): Int {
        val tokens = input.get().map { StringDestructure("^(\\d+)\\s+(\\d+)\$").pair(it) }
        val occurrences = tokens.map { it.second.toInt() }.groupingBy { it }.eachCount()
        return tokens.map { it.first.toInt() }.sorted().sumOf { it * occurrences.getOrDefault(it, 0) }
    }
}
