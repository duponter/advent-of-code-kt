package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): Long {
        return input.get().map { Equation.parse(it) }
            .filter { it.valid() }
            .sumOf { it.result }
    }

    fun part2(input: Lines): Long {
        return input.get()
            .count().toLong()
    }

    data class Equation(val result: Long, val terms: List<Long>) {
        companion object {
            fun parse(input: String): Equation {
                return input.split(": ")
                    .let { Equation(it.first().toLong(), it.last().split(' ').map { t -> t.toLong() }) }
            }
        }

        fun valid(): Boolean = combine(terms.drop(1), listOf(terms[0])).any { it == result }

        private fun combine(remaining: List<Long>, calculations: List<Long> = mutableListOf()): List<Long> {
            if (remaining.isEmpty()) {
                return calculations
            }
            val next = remaining[0]
            return combine(remaining.drop(1), calculations.flatMap { listOf(it + next, it * next) })
        }
    }
}
