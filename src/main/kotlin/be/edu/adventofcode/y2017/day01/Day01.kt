package be.edu.adventofcode.y2017.day01

import be.edu.adventofcode.Text

class Day01 {
    fun part1(input: Text): Int {
        val chars = input.chars()
        return chars.plus(chars.first()).windowed(2)
                .filter { it.first() == it.last() }
                .map { it.first().toString().toInt() }
                .sum()
    }

    fun part2(input: Text): Int {
        val chars = input.chars()
        val halves = chars.windowed(chars.size / 2)
        return chars.zip(halves.last().plus(halves.first()))
                .filter { it.first == it.second }
                .map { it.first.toString().toInt() }
                .sum()

    }
}
