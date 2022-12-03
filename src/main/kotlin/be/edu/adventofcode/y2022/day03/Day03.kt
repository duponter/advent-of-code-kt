package be.edu.adventofcode.y2022.day03

import be.edu.adventofcode.Lines

class Day03 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { it.chunked(it.length / 2) }
            .map { it.first().toSet().intersect(it.last().toSet()).first() }
            .map { if (it.code > 'Z'.code) it.minus('a').plus(1) else it.minus('A').plus(27) }
            .sumOf { it }
    }

    fun part2(input: Lines): Int {
        return input.get().chunked(3)
            .map { it.first().toSet().intersect(it[1].toSet()).intersect(it.last().toSet()).first() }
            .map { if (it.code > 'Z'.code) it.minus('a').plus(1) else it.minus('A').plus(27) }
            .sumOf { it }
    }
}
