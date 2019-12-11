package be.edu.adventofcode.y2019.day09

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2019.intcode.Computer

class Day09 {
    fun part1(input: Text): Long {
        return Computer().execute(input.get(), 1L)
    }

    fun part2(input: Text): Long {
        return input.get().count().toLong()
    }
}
