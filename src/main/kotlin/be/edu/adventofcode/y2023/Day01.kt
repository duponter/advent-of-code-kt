package be.edu.adventofcode.y2023

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return sum(input.get())
    }

    fun part2(input: Lines): Int {
        val digits = listOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        )
        val result: List<String> = input.get()
            .map { it.windowed(5, 1, true).map { t -> prefixDigit(t, digits) }.joinToString { s -> s.first().toString() } }


        return sum(result)
    }

    private fun prefixDigit(input: String, digits: List<String>): String {
        println(input)
        val index = digits.indexOfFirst { input.startsWith(it) }
        return if (index == -1) input else (index + 1).toString() + input
    }

    private fun sum(lines: List<String>): Int {
        return lines.sumOf {
            it.toCharArray().filter { c -> c.isDigit() }.let { d -> d.first().digitToInt() * 10 + d.last().digitToInt() }
        }
    }
}
