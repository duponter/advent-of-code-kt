package be.edu.adventofcode.y2023

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { Game.parse(it) }
            .filter { it.isPossible(Bag()) }
            .sumOf { it.id }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .map { Game.parse(it).minimalBag() }
            .sumOf { it.red * it.green * it.blue }
    }
}

data class Game(val id: Int, val draws: List<Draw>) {
    companion object {
        fun parse(input: String): Game {
            val tokens = input.split(":")
            return Game(tokens.first().removePrefix("Game ").toInt(), tokens.last().split(";").map { Draw.parse(it) })
        }
    }

    fun isPossible(bag: Bag): Boolean = draws.all { it.isPossible(bag) }

    fun minimalBag(): Bag {
        return draws.foldRight(Bag(0,0,0)) { draw, bag -> Bag(maxOf(draw.red, bag.red), maxOf(draw.green, bag.green), maxOf(draw.blue, bag.blue)) }
    }
}

data class Draw(val red: Int, val green: Int, val blue: Int) {
    companion object {
        fun parse(input: String): Draw {
            val tokens = input.trim().split(" ").map { it.trim(',') }
            return Draw(valueOf(tokens, "red"), valueOf(tokens, "green"), valueOf(tokens, "blue"))
        }

        fun valueOf(tokens: List<String>, color: String): Int {
            val indexOf = tokens.indexOf(color)
            return if (indexOf < 0) 0 else tokens[indexOf - 1].toInt()
        }
    }

    fun isPossible(bag: Bag): Boolean = red <= bag.red && green <= bag.green && blue <= bag.blue
}

data class Bag(val red: Int = 12, val green: Int = 13, val blue: Int = 14)
