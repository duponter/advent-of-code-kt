package be.edu.adventofcode.y2021.day07

import be.edu.adventofcode.Text
import kotlin.math.abs

class Day07 {
    fun part1(input: Text): Int {
        val crabPositions = input.get().trim().split(',').map { it.toInt() }
        return (0..crabPositions.maxOrNull()!!)
            .minOf { pos -> crabPositions.sumOf { abs(it - pos) } }
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
