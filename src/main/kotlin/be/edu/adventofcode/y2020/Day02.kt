package be.edu.adventofcode.y2020

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
                .map { parse(it) }
                .count { it.isValidPart1() }
    }

    fun part2(input: Lines): Int {
        return input.get()
                .map { parse(it) }
                .count { it.isValidPart2() }
    }

    private fun parse(policy: String): PasswordEntry {
        return StringDestructure("(\\d+)-(\\d+) ([a-z]): ([a-z]+)").many(policy)
            .let { PasswordEntry(it[0].toInt(), it[1].toInt(), it[2].first(), it[3]) }
    }

    class PasswordEntry(private val lower: Int, private val upper: Int, private val letter: Char, private val pw: String) {

        fun isValidPart1(): Boolean = pw.count { it == letter } in lower..upper

        fun isValidPart2(): Boolean = (pw[lower-1] == letter) xor (pw[upper-1] == letter)
    }
}
