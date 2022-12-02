package be.edu.adventofcode.y2022.day02

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { it.split(' ') }
            .map { Round(Shape.parse(it.first()), Shape.parse(it.last())) }
            .sumOf { it.score() }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }

    data class Round(val opponent: Shape, val player: Shape) {
        private fun outcome(): Int = player.outcome(opponent) * 3

        fun score(): Int = outcome() + player.score
    }

    enum class Shape(val score: Int) {
        ROCK(1) {
            override fun outcome(other: Shape): Int {
                return when (other) {
                    ROCK -> 1
                    PAPER -> 0
                    SCISSORS -> 2
                }
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
        },
        SCISSORS(3) {
            override fun outcome(other: Shape): Int {
                return when (other) {
                    ROCK -> 0
                    PAPER -> 2
                    SCISSORS -> 1
                }
            }
        };

        abstract fun outcome(other: Shape): Int;

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
