package be.edu.adventofcode.y2019.day04

import be.edu.adventofcode.Lines
import be.edu.adventofcode.Text
import kotlin.math.abs
import kotlin.math.log10

class Day04 {
    fun part1(input: Text): Int {
        val range = input.get().split("-").map { it.toInt() }
        return IntRange(range.first(), range.last())
                .filter { valid(it.toString()) }
                .count()
    }

    fun valid(password: String): Boolean = valid(password.toList().map { it.toInt() }.toIntArray())

    private fun valid(password: IntArray): Boolean {
        val sixDigits = { ints: IntArray -> ints.size == 6 }
        val neverDecrease = { ints: IntArray -> ints.sortedArray().contentEquals(ints) }
        val sameAdjacentDigits = { ints: IntArray -> ints.toList()
                    .windowed(2) { it.distinct().size }
                    .any { it == 1 }
        }
        return sixDigits(password) && neverDecrease(password) && sameAdjacentDigits(password)
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

fun Int.length() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}
