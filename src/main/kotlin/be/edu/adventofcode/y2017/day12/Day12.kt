package be.edu.adventofcode.y2017.day12

import be.edu.adventofcode.Lines

class Day12 {
    fun part1(input: Lines): Int {
        var map = input.get().map { split(it) }.toMap()
        var collected = setOf(0)

        do {
            val size = collected.size
            val split = map.split(collected)
            collected = collected.plus(split.first.values.flatMap { it })
            map = split.second
        } while (size < collected.size)

        return collected.size
    }

    private fun split(input: String): Pair<Int, List<Int>> = input.split(" <-> ")
            .let { Pair(it.first().toInt(), it.last().split(Regex(",\\s*")).map(String::toInt)) }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

private fun <K, V> Map<K, V>.split(keys: Iterable<K>): Pair<Map<K, V>, Map<K, V>> = Pair(this.filterKeys(keys::contains), this.minus(keys))