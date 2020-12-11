package be.edu.adventofcode.y2020.day10

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.pow

class Day10 {
    fun part1(input: Lines): Int {
        val joltDifferenceCount: Map<Int, Int> = outputJoltages(input)
            .windowed(2)
            .map { it[1] - it[0] }
            .groupingBy { it }
            .eachCount()

        return joltDifferenceCount[1]!! * joltDifferenceCount[3]!!
    }

    private fun outputJoltages(input: Lines): Set<Int> {
        val outputJoltages = input.get().map { it.toInt() }.toSortedSet()
        return outputJoltages + listOf(0, outputJoltages.maxOrNull()!! + 3)
    }

    fun part2(input: Lines): Int {
        println(fibonacci().take(10).toList()) // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

        val outputJoltages: Set<Int> = input.get().map { it.toInt() }.toSortedSet()
        println("# adapters = ${outputJoltages.size}")
        println("# max output joltage = ${outputJoltages.maxOrNull()}")

        val steps: Int = ceil(outputJoltages.maxOrNull()!!.toDouble() / 3).toInt()
        println("min # staps = $steps")

        val groupByQuotient: Map<Int, List<Int>> = outputJoltages.groupBy { ceil(it.toDouble() / 3).toInt() }
        val toMutableMap = groupByQuotient.toMutableMap()
        toMutableMap[0] = listOf(0)
        toMutableMap[steps + 1] = listOf(outputJoltages.maxOrNull()!! + 3)
        println(toMutableMap)

        val combinations = (1..steps).map { combo(toMutableMap, it) }
        println(combinations)
        return combinations.reduce { product, next -> product * next }
    }

    fun fibonacci(): Sequence<Int> {
        // fibonacci terms
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
        return generateSequence(Pair(0, 1), { Pair(it.second, it.first + it.second) }).map { it.first }
    }

    private fun combo(groupByQuotient: Map<Int, List<Int>>, index: Int): Int {
        val current = groupByQuotient[index]!!
        if (current.size == 1) return 1

        val maxPrev: Int = groupByQuotient[index - 1]?.maxOrNull()!!
        val left: Int = current.filter { it < maxPrev + 4 }.size

        val minNext: Int = groupByQuotient[index + 1]?.minOrNull()!!
        val right: Int = current.filter { it + 4 > minNext }.size

        return (possibleCombos(current.size) - possibleCombos(current.size - left) - possibleCombos(current.size - right)) * (max(0, current.size - left - right) + 1)
    }

    private fun possibleCombos(numberOfElements: Int): Int = 2.toDouble().pow(numberOfElements).toInt() - 1
}

fun main() {
    println(Day10().part2(LinesFromArray("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")))
    println(Day10().part2(LinesFromArray("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")))
}