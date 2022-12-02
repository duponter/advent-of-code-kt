package be.edu.adventofcode.y2022.day02

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { it.split(' ') }
            .map { Round1(Shape.parse(it.first()), Shape.parse(it.last())) }
            .sumOf { it.score() }
    }

    data class Round1(val opponent: Shape, val player: Shape) {
        private fun outcome(): Int = player.outcome(opponent) * 3

        fun score(): Int = outcome() + player.score
    }

    fun part2(input: Lines): Int {
        return input.get()
            .map { it.split(' ') }
            .map { Round2(Shape.parse(it.first()), it.last()) }
            .sumOf { it.score() }
    }

    data class Round2(val opponent: Shape, val result: String) {
        private fun outcome(): Int = when (result) {
            "X" -> 0
            "Y" -> 1
            "Z" -> 2
            else -> throw IllegalArgumentException("No outcome for result '$result'")
        }

        fun score(): Int {
            val outcome = outcome()
            return outcome * 3 + opponent.chooseForOutcome(outcome).score
        }
    }

    enum class Shape(val score: Int) {
        ROCK(1) {
            override fun outcome(other: Shape): Int = when (other) {
                ROCK -> 1
                PAPER -> 0
                SCISSORS -> 2
            }

            override fun chooseForOutcome(outcome: Int): Shape = when (outcome) {
                0 -> SCISSORS
                1 -> ROCK
                2 -> PAPER
                else -> throw IllegalArgumentException("No Shape for outcome '$outcome'")
            }
        },
        PAPER(2) {
            override fun outcome(other: Shape): Int {
                return when (other) {
                    ROCK -> 2
                    PAPER -> 1
                    SCISSORS -> 0
                }
            }

            override fun chooseForOutcome(outcome: Int): Shape = when (outcome) {
                0 -> ROCK
                1 -> PAPER
                2 -> SCISSORS
                else -> throw IllegalArgumentException("No Shape for outcome '$outcome'")
            }
        },
        SCISSORS(3) {
            override fun outcome(other: Shape): Int {
                return when (other) {
                    ROCK -> 0
                    PAPER -> 2
                    SCISSORS -> 1
                }
            }

            override fun chooseForOutcome(outcome: Int): Shape = when (outcome) {
                0 -> PAPER
                1 -> SCISSORS
                2 -> ROCK
                else -> throw IllegalArgumentException("No Shape for outcome '$outcome'")
            }
        };

        abstract fun outcome(other: Shape): Int

        abstract fun chooseForOutcome(outcome: Int): Shape

        companion object Parser {
            fun parse(input: String): Shape {
                return when (input.first()) {
                    'A', 'X' -> ROCK
                    'B', 'Y' -> PAPER
                    'C', 'Z' -> SCISSORS
                    else -> throw IllegalArgumentException("No Shape for '$input'")
                }
            }
        }
    }
}
