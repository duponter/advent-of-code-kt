package be.edu.adventofcode.y2021.day08

import be.edu.adventofcode.Lines
import be.edu.adventofcode.calculations.CartesianProduct

class Day08 {
    fun part1(input: Lines): Int {
        val acceptedSizes = listOf(2, 3, 4, 7)
        return input.get().asSequence()
            .map { it.split(" | ") }
            .map { it[0].split(" ").map { s -> s.length }.toSortedSet() to it[1].split(" ").map { s -> s.length } }
            .map {
                val toMutableList = it.second.toMutableList()
                toMutableList.retainAll(acceptedSizes)
                toMutableList.retainAll(it.first)
                toMutableList.toList()
            }
            .map { it.filter { s -> acceptedSizes.contains(s) } }.sumOf { it.size }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Digit(val segments: String) {
    companion object Static {
        fun digits(): List<Digit> {
            return listOf(
                Digit("abcefg"),
                Digit("cf"),
                Digit("acdeg"),
                Digit("acdfg"),
                Digit("bcdf"),
                Digit("abdfg"),
                Digit("abdefg"),
                Digit("acf"),
                Digit("abcdefg"),
                Digit("abcdfg")
            )
        }
    }

    fun decode(signals: String): List<Pair<Char, Char>> {
        if (signals.length != this.segments.length) {
            return emptyList()
        }
        return CartesianProduct.pair(segments.toSortedSet(), signals.toSortedSet())
    }

    private fun orderedSegments(): String {
        return "abcdefg"
            .map { if (segments.contains(it)) it else '.' }
            .joinToString("")
    }

    fun print(): String {
        val orderedSegments = orderedSegments()
        return listOf(
            printHorizontally(orderedSegments[0]),
            printVertically(orderedSegments[1], orderedSegments[2]),
            printVertically(orderedSegments[1], orderedSegments[2]),
            printHorizontally(orderedSegments[3]),
            printVertically(orderedSegments[4], orderedSegments[5]),
            printVertically(orderedSegments[4], orderedSegments[5]),
            printHorizontally(orderedSegments[6])
        ).joinToString("\n")
    }

    private fun printHorizontally(segment: Char = '.'): String = " $segment$segment$segment$segment "

    private fun printVertically(segment1: Char = '.', segment2: Char = '.'): String = "$segment1    $segment2"
}

