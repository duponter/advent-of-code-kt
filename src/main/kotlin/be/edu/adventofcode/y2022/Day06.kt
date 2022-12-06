package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.Text

class Day06 {
    fun part1(input: Text): Int {
        val datastream = input.get()
        val marker = datastream.windowedSequence(4).toList().first { it.toSet().size == 4 }
        return datastream.length - datastream.substringAfter(marker).length
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}
