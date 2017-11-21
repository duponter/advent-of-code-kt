package be.edu.adventofcode.y2015.day05

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int = input.get().count { it.nice() }

    fun part2(input: Lines): Int = input.get().count { it.nice2() }

    private fun String.nice(): Boolean {
        val doubleLetters = CharRange('a', 'z').map {
            it.toString() + it
        }
        val forbidden = listOf("ab", "cd", "pq", "xy")
        val vowels = "aeiou".toList()
        val letterPairs = this.sliding(2)
        return letterPairs.none { forbidden.contains(it) }
                && letterPairs.any { doubleLetters.contains(it) }
                && this.count { vowels.contains(it) } > 2
    }

    private fun String.nice2(): Boolean {
        val pairs = this.sliding(2).groupBy { it }.filter { it.value.size > 1 }
        val repeatingTriples = this.sliding(3)
                .filter { it.length == 3 }
                .filter { it.first() == it.last() }

        val overlappingTriples = repeatingTriples.filter { it.take(2) == it.drop(1) }
        return pairs.isNotEmpty() && repeatingTriples.count() > 0 &&
                (overlappingTriples.count() == 0 || overlappingTriples.all { pairs[it.take(2)].orEmpty().count() > 2 })
    }

    private fun String.sliding(size: Int): Sequence<String> = this.sliding(sequenceOf<String>(), size)

    private fun String.sliding(seq: Sequence<String>, size: Int): Sequence<String> {
        if (!this.isEmpty()) {
            return this.drop(1).sliding(seq.plus(this.take(size)), size)
        }
        return seq
    }

}
