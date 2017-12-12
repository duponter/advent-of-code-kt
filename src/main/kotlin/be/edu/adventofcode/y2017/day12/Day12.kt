package be.edu.adventofcode.y2017.day12

import be.edu.adventofcode.Lines

class Day12 {
    fun part1(input: Lines): Int = group(input.get().map { split(it) }.toMap(), 0).first.size

    private fun split(input: String): Pair<Int, List<Int>> = input.split(" <-> ")
            .let { Pair(it.first().toInt(), it.last().split(Regex(",\\s*")).map(String::toInt)) }

    private fun group(programs: Map<Int, List<Int>>, key: Int): Pair<Set<Int>, Map<Int, List<Int>>> {
        var collected = setOf(key)
        var remaining = programs

        do {
            val size = collected.size
            val split = remaining.split(collected)
            collected = collected.plus(split.first.values.flatMap { it })
            remaining = split.second
        } while (size < collected.size)

        return Pair(collected, remaining)
    }

    fun part2(input: Lines): Int = count(input.get().map { split(it) }.toMap())

    private fun count(programs: Map<Int, List<Int>>): Int =
            if (programs.isEmpty()) 0 else 1 + count(group(programs, programs.keys.first()).second)
}

private fun <K, V> Map<K, V>.split(keys: Iterable<K>): Pair<Map<K, V>, Map<K, V>> = Pair(this.filterKeys(keys::contains), this.minus(keys))