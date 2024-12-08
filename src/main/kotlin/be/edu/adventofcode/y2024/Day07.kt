package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): Long {
        return input.get().map { Equation.parse(it) }
            .filter { it.valid() }
            .sumOf { it.result }
    }

    fun part2(input: Lines): Long {
        return input.get().map { Equation.parse(it) }
            .filter { it.valid2() }
            .sumOf { it.result }
    }

    data class Equation(val result: Long, val terms: List<Long>) {
        companion object {
            fun parse(input: String): Equation {
                return input.split(": ")
                    .let { Equation(it.first().toLong(), it.last().split(' ').map { t -> t.toLong() }) }
            }
        }

        fun valid(): Boolean = combine(terms.drop(1), listOf(terms[0])).any { it == result }

        fun valid2(): Boolean {
            if (valid()) {
                return true
            }
            println(this)


            val combinedTerms = combineTerms(terms.windowed(2, partialWindows = true))
                .map { Equation(result, it) }
            combinedTerms.withIndex().forEach { println(it) }
            return combinedTerms
                .any { it.valid() }
        }

        private fun combine(remaining: List<Long>, calculations: List<Long>): List<Long> {
            if (remaining.isEmpty()) {
                return calculations
            }
            val next = remaining[0]
            return combine(remaining.drop(1), calculations.flatMap { listOf(it + next, it * next) })
        }

        private fun combineTerms(windowed: List<List<Long>>): List<List<Long>> {
            println("$windowed")
            if (windowed.isEmpty()) {
                return listOf()
            }

            val next = windowed[0]
            if (windowed.size == 1) {
                return if (next.size == 1) {
                    listOf(listOf(next[0]))
                } else {
                    listOf(listOf(next[0], next[1]), listOf("${next[0]}${next[1]}".toLong()))
                }
            }
            return listOf(next[0]).let { combineTerms(windowed.drop(1)).map { t -> it.plus(t) } }
                .plus(listOf("${next[0]}${next[1]}".toLong()).let { combineTerms(windowed.drop(2)).map { t -> it.plus(t) } })
        }
    }
}
