package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { Report.parse(it) }
            .count { it.safe() }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }

    data class Report(val levels: List<Int>) {
        companion object {
            fun parse(input: String): Report {
                return Report(input.split(' ').map { it.toInt() })
            }
        }

        fun safe(): Boolean {
            val diffs = levels.zipWithNext { a, b -> a - b }

            val min = diffs.minOrNull()!!
            val max = diffs.maxOrNull()!!

            return (min >= 1 && max <= 3) || (min >= -3 && max <= -1)
        }
    }
}
