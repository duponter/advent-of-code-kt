package be.edu.adventofcode.y2021.day14

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure

class Day14 {
    fun part1(input: Lines, steps: Int = 10): Int {
        val lines = input.get()
        val insertionRules: Map<String, String> = parseInsertionRules(lines)
        val elementCount = repeatInsertions(insertionRules, lines.first(), steps).groupingBy { it }.eachCount()
        return elementCount.maxByOrNull { it.value }!!.value - elementCount.minByOrNull { it.value }!!.value
    }

    fun part2(input: Lines, steps: Int = 40): Long {
        val lines = input.get()
        val insertionRules: Map<String, String> = parseInsertionRules(lines)

        val tenStepInsertions: Map<String, Polymer10> = insertionRules.mapValues { Polymer10(it.key, repeatInsertions(insertionRules, it.key, 10)) }
        val elementCount: Map<Char, Long> = lines.first()
            .windowed(2) { tenStepInsertions[it]!!.extrapolate(tenStepInsertions, steps / 10) }
            .fold(mutableMapOf(lines.first().first() to 1)) { acc, curr ->
                curr.forEach { entry ->
                    acc.merge(entry.key, entry.value) { new, old -> new + old }
                }
                acc
            }
        return elementCount.maxByOrNull { it.value }!!.value - elementCount.minByOrNull { it.value }!!.value
    }

    private fun parseInsertionRules(lines: List<String>): Map<String, String> {
        val destructure = StringDestructure("([A-Z]+) -> ([A-Z])")
        return lines.drop(2)
            .map { destructure.pair(it) }
            .associate { it.first to listOf(it.first.take(1), it.second, it.first.takeLast(1)).joinToString("") }
    }

    private tailrec fun repeatInsertions(insertionRules: Map<String, String>, input: String, steps: Int): String {
        if (steps == 0) {
            return input
        }
        return repeatInsertions(
            insertionRules,
            input.take(1) + input.windowed(2) { insertionRules[it] ?: it }.joinToString("") { it.drop(1) },
            steps - 1
        )
    }
}

data class Polymer10(val input: String, val polymerCount: Map<String, Int>, val charCounts: Map<Char, Long>) {
    constructor(input: String, output: String) : this(
        input,
        output.windowed(2).groupingBy { it }.eachCount(),
        output.drop(1).groupingBy { it }.eachCount().mapValues { it.value.toLong() }
    )

    fun extrapolate(polymers: Map<String, Polymer10>, times: Int): Map<Char, Long> {
        if (times == 1) {
            return charCounts
        }
        return polymerCount.map { polymers[it.key]!!.extrapolate(polymers, times - 1).mapValues { cnt -> cnt.value * it.value } }
            .fold(mutableMapOf()) { acc, curr ->
                curr.forEach { entry ->
                    acc.merge(entry.key, entry.value) { new, old -> new + old }
                }
                acc
            }
    }
}

