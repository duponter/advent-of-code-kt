package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray

class Day15 {
    fun part1(input: Lines): Int {
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

fun main() {
    val testInput = LinesFromArray(
        "1163751742",
        "1381373672",
        "2136511328",
        "3694931569",
        "7463417111",
        "1319128137",
        "1359912421",
        "3125421639",
        "1293138521",
        "2311944581"
    )
    println("Day 15, part 1 = ${Day15().part1(testInput)}")
//    println("Day 15, part 2 = ${Day15().part2(testInput)}")
}
