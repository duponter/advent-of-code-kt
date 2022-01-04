package be.edu.adventofcode.y2021.day14

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure

class Day14 {
    fun part1(input: Lines, steps: Int = 10): Int {
        val lines = input.get()
        val insertionRules: Map<String, String> = parseInsertionRules(lines)
        val template = lines.first()

        var polymer = template
        for (step in 1..steps) {
            polymer = template.take(1) + polymer
                .windowed(2) { insertionRules[it] ?: it }
                .joinToString("") { it.drop(1) }
        }

        val elementCount = polymer.groupingBy { it }.eachCount()
        return elementCount.maxByOrNull { it.value }!!.value - elementCount.minByOrNull { it.value }!!.value
    }

    fun part2(input: Lines, steps: Int = 40): Long {
        val lines = input.get()
        val insertionRules: Map<String, String> = parseInsertionRules(lines)
        val template = lines.first()
        val elementCount: MutableMap<Char, Long> = recursive(insertionRules, steps, template).toMutableMap()
        elementCount[template.first()] = (elementCount[template.first()] ?: 0L) + 1
        return elementCount.maxByOrNull { it.value }!!.value - elementCount.minByOrNull { it.value }!!.value
    }

    private fun recursive(insertionRules: Map<String, String>, steps: Int, input: CharSequence): Map<Char, Long> {
        if (steps == 0) {
            return input.drop(1).groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        }
        if (input.length == 2) {
            return if (insertionRules.containsKey(input)) {
                recursive(insertionRules, steps - 1, insertionRules[input]!!)
            } else {
                recursive(insertionRules, 0, input)
            }
        }
        return input.windowed(2) { recursive(insertionRules, steps, it) }
            .fold(hashMapOf()) { acc, curr ->
                curr.forEach { entry ->
                    acc.merge(entry.key, entry.value) { new, old -> new + old }
                }
                acc
            }
    }

    private fun parseInsertionRules(lines: List<String>): Map<String, String> {
        val destructure = StringDestructure("([A-Z]+) -> ([A-Z])")
        return lines.drop(2)
            .map { destructure.pair(it) }
            .associate { it.first to listOf(it.first.take(1), it.second, it.first.takeLast(1)).joinToString("") }
    }
}
