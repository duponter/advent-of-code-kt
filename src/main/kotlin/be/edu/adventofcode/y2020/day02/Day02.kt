package be.edu.adventofcode.y2020.day02

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
                .map { parse(it) }
                .count { it.isValid() }
    }

    private fun parse(policy: String): PasswordEntry {
        return Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)").matchEntire(policy)!!.destructured.let {
            PasswordEntry(it.component1().toInt(), it.component2().toInt(), it.component3().first(), it.component4())
        }
    }

    class PasswordEntry(private val lower: Int, private val upper: Int, private val letter: Char, private val pw: String) {
        fun isValid(): Boolean = pw.count { it == letter } in lower..upper
    }


    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
