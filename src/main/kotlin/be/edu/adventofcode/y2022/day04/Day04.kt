package be.edu.adventofcode.y2022.day04

import be.edu.adventofcode.Lines

class Day04 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { it.split(',') }
            .map { toAssignmentPair(it) }
            .count { it.first.containsAll(it.second) || it.second.containsAll(it.first) }
    }

    private fun toAssignmentPair(input: List<String>): Pair<Set<Int>, Set<Int>> = input.map { toSections(it) }
        .let { it.first() to it.last() }

    private fun toSections(input: String): Set<Int> = input.split('-')
        .map { it.toInt() }
        .let { it.first()..it.last() }
        .toSortedSet()

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
