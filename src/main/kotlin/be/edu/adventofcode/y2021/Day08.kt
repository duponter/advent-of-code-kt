package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines

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
        val digits = Digits()
        return input.get().asSequence()
            .map { it.split(" | ") }
            .map { digits.fromSignals(it[0].split(" ")) to it[1].split(" ") }
            .map { it.second.map { d -> it.first.digitOf(d) } }
            .map { it.joinToString("") { d -> d.digit } }
            .sumOf { it.toInt() }
    }
}

data class Digits(val digits: List<Digit>) {
    constructor() : this(listOf())

    fun fromSignals(signals: List<String>): Digits {
        return Digits(fromSignals(signals.groupBy { it.length }))
    }

    private fun fromSignals(signals: Map<Int, List<String>>): List<Digit> {
        return signals.flatMap { fromSignals(signals, it) }
    }

    private fun fromSignals(signals: Map<Int, List<String>>, entry: Map.Entry<Int, List<String>>): List<Digit> {
        return when (entry.key) {
            2 -> listOf(Digit(1, entry.value.first().toCharArray()))
            3 -> listOf(Digit(7, entry.value.first().toCharArray()))
            4 -> listOf(Digit(4, entry.value.first().toCharArray()))
            5 -> len5Digit(signals[4]!!.first(), entry.value)
            6 -> len6Digit(signals[2]!!.first(), signals[4]!!.first(), entry.value)
            7 -> listOf(Digit(8, entry.value.first().toCharArray()))
            else -> throw IllegalArgumentException(entry.toString())
        }
    }

    private fun len5Digit(signal4: String, signals: List<String>): List<Digit> {
        check(signals.size == 3)
        val result4x = signal4.filterNot { signals[0].contains(it) }
        val result4y = signal4.filterNot { signals[1].contains(it) }
        val resultxy = signals[0].filterNot { signals[1].contains(it) }
        val resultxz = signals[0].filterNot { signals[2].contains(it) }
        val resultyx = signals[1].filterNot { signals[0].contains(it) }
        val resultyz = signals[1].filterNot { signals[2].contains(it) }

        return if (resultxy.length == resultxz.length) {
            if (result4y.length == 1) listOf(3, 5, 2) else listOf(3, 2, 5)
        } else {
            if (resultyx.length == resultyz.length) {
                if (result4x.length == 1) listOf(5, 3, 2) else listOf(2, 3, 5)
            } else {
                if (result4x.length == 1) listOf(5, 2, 3) else listOf(2, 5, 3)
            }
        }.mapIndexed { idx, digit -> Digit(digit, signals[idx].toCharArray()) }
    }

    private fun len6Digit(signal1: String, signal4: String, signals: List<String>): List<Digit> {
        check(signals.size == 3)
        val result1x = signal1.filterNot { signals[0].contains(it) }
        val result1y = signal1.filterNot { signals[1].contains(it) }
        val result4x = signal4.filterNot { signals[0].contains(it) }
        val result4y = signal4.filterNot { signals[1].contains(it) }

        return if (result1x.isNotEmpty()) {
            if (result4y.isNotEmpty()) listOf(6, 0, 9) else listOf(6, 9, 0)
        } else {
            if (result1y.isNotEmpty()) {
                if (result4x.isNotEmpty()) listOf(0, 6, 9) else listOf(9, 6, 0)
            } else {
                if (result4x.isNotEmpty()) listOf(0, 9, 6) else listOf(9, 0, 6)
            }
        }.mapIndexed { idx, digit -> Digit(digit, signals[idx].toCharArray()) }
    }

    fun digitOf(input: String): Digit = digits.first { it.equalTo(input) }
}

data class Digit(val digit: String, val segments: String) {
    constructor(digit: Int, segments: CharArray) : this(digit.toString(), segments.sortedArray().joinToString(""))

    fun equalTo(input: String): Boolean {
        val acceptedSizes = listOf(2, 3, 4, 7)
        if (acceptedSizes.contains(input.length)) {
            return input.length == segments.length
        }
        return segments.contentEquals(input.toCharArray().sortedArray().joinToString(""))
    }

    private fun orderedSegments(): String {
        return "abcdefg"
            .map { if (segments.contains(it)) it else '.' }
            .joinToString("")
    }

    fun print(): String {
        val orderedSegments = orderedSegments()
        return listOf(
            printHorizontally(orderedSegments[3]),
            printVertically(orderedSegments[4], orderedSegments[0]),
            printVertically(orderedSegments[4], orderedSegments[0]),
            printHorizontally(orderedSegments[5]),
            printVertically(orderedSegments[6], orderedSegments[1]),
            printVertically(orderedSegments[6], orderedSegments[1]),
            printHorizontally(orderedSegments[2])
        ).joinToString("\n")
    }

    private fun printHorizontally(segment: Char = '.'): String = " $segment$segment$segment$segment "

    private fun printVertically(segment1: Char = '.', segment2: Char = '.'): String = "$segment1    $segment2"
}

