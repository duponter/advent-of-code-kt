package be.edu.adventofcode.y2021.day06

import be.edu.adventofcode.Text

class Day06 {
    fun part1(input: Text, days: Int = 80): Int {
        var fish = input.get().trim().split(',').map { it.toInt() }
        for (day in 1..days) {
            fish = cycle(fish)
        }
        return fish.size
    }

    private fun cycle(fish: List<Int>): List<Int> = fish.map { if (it == 0) 6 else it - 1 } + generateSequence(8) { it }.take(fish.count { it == 0 }).toList()

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
