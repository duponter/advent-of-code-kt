package be.edu.adventofcode.y2020.day04

import be.edu.adventofcode.Text

class Day04 {
    fun part1(input: Text): Int {
        return input.get().split("\n\n")
            .count { it.count { c -> c == ':' } == 8 || (it.count { c -> c == ':' } == 7 && !it.contains("cid:")) }
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
