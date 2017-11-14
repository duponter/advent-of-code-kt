package be.edu.adventofcode.y2015.day03

import java.io.File

class Day03 {
    fun part1(): Int {
        return File(this.javaClass.getResource("Day03.txt").toURI()).readLines().count()
    }

    fun part2(): Int {
        return File(this.javaClass.getResource("Day03.txt").toURI()).readLines().count()
    }
}
