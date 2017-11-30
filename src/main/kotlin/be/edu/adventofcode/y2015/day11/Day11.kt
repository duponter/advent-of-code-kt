package be.edu.adventofcode.y2015.day11

import be.edu.adventofcode.Text
import be.edu.adventofcode.TextFromString

class Day11 {
    fun part1(input: Text): String = generateSequence(input.get(), String::inc).drop(1)
            .first { meetsRequirements(it) }

    fun part2(input: Text): String {
        return part1(TextFromString(part1(input)))
    }

    fun meetsRequirements(input: String): Boolean = noConfusingLetters(input) && oneIncreasingLetterTriple(input) && twoLetterPairs(input)

    private fun noConfusingLetters(input: String) = listOf('i', 'o', 'l').none { input.contains(it) }

    private fun oneIncreasingLetterTriple(input: String): Boolean = ('a'..'x').map { "$it${it.inc()}${it.inc().inc()}" }
            .filter { noConfusingLetters(it) }
            .any { input.contains(it) }


    private fun twoLetterPairs(input: String): Boolean {
        val atLeastPairs = input.groupSimilar().filter { it.length > 1 }
        return atLeastPairs.size > 1 || atLeastPairs.firstOrNull()?.length ?: 0 > 3
    }
}


fun String.inc(): String {
    val last = this.last()
    val remaining = this.dropLast(1)

    return if (last != 'z') {
        remaining.plus(last.inc())
    } else {
        remaining.inc().plus('a')
    }
}

fun String.groupSimilar(): List<String> = this.split(Regex("(?<=(.))(?!\\1)")).dropLastWhile { it.isEmpty() }