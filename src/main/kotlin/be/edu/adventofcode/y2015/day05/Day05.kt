package be.edu.adventofcode.y2015.day05

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int = input.get().count { it.nice() }

    fun part2(input: Lines): Int = input.get().count { it.nice2() }

    private fun String.nice(): Boolean {
        val doubleLetters = CharRange('a', 'z').map {
            it.toString() + it
        }
        println(doubleLetters)
        val forbidden = listOf("ab", "cd", "pq", "xy")
        println(forbidden)
        val vowels = "aeiou".toList()
        println(vowels)
        val letterPairs = this.sliding(2)
        println(letterPairs.toList())
        return letterPairs.none { forbidden.contains(it) }
                && letterPairs.any { doubleLetters.contains(it) }
                && this.count { vowels.contains(it) } > 2
    }

    private fun String.nice2(): Boolean {
        return false;
    }

    private fun String.sliding(size: Int): Sequence<String> = this.sliding(sequenceOf<String>(), size)

    private fun String.sliding(seq: Sequence<String>, size: Int): Sequence<String> {
        if (!this.isEmpty()) {
            return this.drop(1).sliding(seq.plus(this.take(size)), size)
        }
        return seq
    }

}
