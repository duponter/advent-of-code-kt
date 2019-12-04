package be.edu.adventofcode.y2019.day04

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

    fun part2(input: Text): Int {
        val range = input.get().split("-").map { it.toInt() }
        return IntRange(range.first(), range.last())
                .filter { validNoLargerGroup(it.toString()) }
                .count()
    }

    fun validNoLargerGroup(password: String): Boolean {
        val passwordInts = password.toList().map { it.toInt() }.toIntArray()
        return valid(passwordInts) && noLargerGroup(passwordInts)
    }

    private fun noLargerGroup(password: IntArray): Boolean {
        val end = password
                .fold(Triple(0, 0, false)) { triple: Triple<Int, Int, Boolean>, next: Int -> checkTriple(triple, next) }
        return end.third || end.second == 2
    }

    private fun checkTriple(triple: Triple<Int, Int, Boolean>, next: Int): Triple<Int, Int, Boolean> {
        if (triple.third) return triple

        return when {
            triple.first == next -> Triple(next, triple.second + 1, false)
            triple.second == 2 -> Triple(triple.first, triple.second, true)
            else -> Triple(next, 1, false)
        }
    }
}

fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}
