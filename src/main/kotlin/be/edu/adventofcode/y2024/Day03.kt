package be.edu.adventofcode.y2024

import be.edu.adventofcode.Text

class Day03 {
    fun part1(input: Text): Int {
        return "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex().findAll(input.get())
            .sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
    }

    fun part2(input: Text): Int {
        return input.get()
            .count()
    }
}
