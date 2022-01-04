package be.edu.adventofcode.y2021.day14

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure

class Day14 {
    fun part1(input: Lines, steps: Int = 10): Int {
        val lines = input.get()
        val destructure = StringDestructure("([A-Z]+) -> ([A-Z])")
        val insertionRules: Map<String, String> = lines.drop(2)
            .map { destructure.pair(it) }
            .associate { it.first to listOf(it.first.take(1), it.second, it.first.takeLast(1)).joinToString("") }
        val template = lines.first()

        var polymer = template
        for (step in 1..steps) {
            polymer = template.take(1) + polymer
                .windowed(2) { insertionRules[it] ?: it }
                .joinToString("") { it.drop(1) }
        }

        val elementCount = polymer.groupBy { it }.mapValues { it.value.size }
        return elementCount.maxByOrNull { it.value }!!.value - elementCount.minByOrNull { it.value }!!.value
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

fun main() {
    val group = "AABBCCCCCCDDD".groupBy { it }.mapValues { it.value.size }
    group.forEach { println(it) }
    println("max: ${group.maxByOrNull { it.value }}")
    println("min: ${group.minByOrNull { it.value }}")
}
