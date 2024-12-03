package be.edu.adventofcode.y2024

import be.edu.adventofcode.Text

class Day03 {
    fun part1(input: Text): Int {
        val text = input.get()
        return sumMultiplications(text)
    }

    fun part2(input: Text): Int {
        return input.get().split("(?=don't\\(\\)|do\\(\\))".toRegex())
            .filter { !it.startsWith("don't()") }
            .sumOf { sumMultiplications(it) }
    }

    private fun sumMultiplications(text: String): Int {
        return "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex().findAll(text)
            .sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
    }
}
