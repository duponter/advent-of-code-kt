package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.Text

class Day12 {
    fun part1(input: Text): Int = calculate(input.get())

    fun part2(input: Text): Int {
        var text = input.get()

        println("--- # characters input = ${text.length} with ${text.count { it == '{' }} { ---")

        while (text.contains('{')) {
            println("--- iteration = ${text.length} with ${text.count { it == '{' }} { ---")
            text = removeBraces(text.split("{").joinToString("{") { includeNonRed(ignoreRed(it)) })
        }
        println(text)

        return calculate(text)
    }

    private fun calculate(input: String): Int = Regex("(-?\\d+)").findAll(input).map { it.value.toInt() }.sum()

    private fun ignoreRed(input: String): String = Regex("[^{}]*?:\"red\"[^{}]*?}").replaceFirst(input, "0}")

    private fun includeNonRed(input: String): String {
        val value = Regex("[^}]*}").find(input)?.value
        return if (value != null) calculate(value).toString().plus("}").plus(input.takeLast(input.length - value.length)) else input
    }

    private fun removeBraces(input: String): String {
        return Regex("\\{(-?\\d+)}").replace(input, { it.destructured.component1() })
    }
}
