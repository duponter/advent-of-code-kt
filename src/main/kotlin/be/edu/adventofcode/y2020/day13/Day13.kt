package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.Lines
import kotlin.math.ceil

class Day13 {
    fun part1(input: Lines): Int {
        val tokens = input.get()
        val timestamp = tokens[0].toInt()
        return tokens[1].split(',')
            .asSequence()
            .filterNot { it == "x" }
            .map { it.toInt() }
            .map { it to ceil(timestamp.toDouble() / it).toInt() * it }
            .map { it.first to it.second - timestamp }
            .minByOrNull { it.second }!!
            .let { it.first * it.second }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
