package be.edu.adventofcode.y2020.day03

import be.edu.adventofcode.Lines

class Day03 {
    fun part1(input: Lines): Int {
        return slopeTreeCount(input, 3, 1)
    }

    fun part2(input: Lines): Long {
        return sequenceOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { slopeTreeCount(input, it.first, it.second) }
            .fold(1, { acc, next -> acc * next } )
    }

    fun slopeTreeCount(input: Lines, right: Int, down: Int): Int {
        return input.get()
            .filterIndexed { index, _ -> index % down == 0 }
            .mapIndexed { index, line -> line[index * right % line.length] }
            .drop(1)
            .count { it == '#' }
    }
}
