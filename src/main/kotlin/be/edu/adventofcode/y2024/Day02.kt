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
            .map { Report.parse(it) }
            .count { it.safeWithDampener() }
    }

    data class Report(val levels: List<Int>, val asc: Boolean) {

        constructor(levels: List<Int>) : this(levels, levels.last() - levels.first() > 0)

        companion object {
            fun parse(input: String): Report {
                val levels = input.split(' ').map { it.toInt() }
                val comparisons = levels.zipWithNext { a, b -> a.compareTo(b) }

                return Report(levels, comparisons.count { it < 0 } > comparisons.count { it > 0 })
            }
        }

        fun safe(): Boolean {
            val diffs = levels.zipWithNext { a, b -> a - b }

            val min = diffs.minOrNull()!!
            val max = diffs.maxOrNull()!!

            return (min >= 1 && max <= 3) || (min >= -3 && max <= -1)
        }

        fun safeWithDampener(): Boolean {
            if (safe()) {
                return true
            }

            return levels.indices
                .map {
                    val mutableLevels = levels.toMutableList()
                    mutableLevels.removeAt(it)
                    Report(mutableLevels)
                }
                .any { it.safe() }
        }
    }
}
