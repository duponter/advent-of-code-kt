package be.edu.adventofcode.y2020.day03

import be.edu.adventofcode.Lines

class Day03 {
    fun part1(input: Lines): Int {
        return input.get()
            .mapIndexed { index, line -> line[index * 3 % line.length] }
            .drop(1)
            .count { it == '#' }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
