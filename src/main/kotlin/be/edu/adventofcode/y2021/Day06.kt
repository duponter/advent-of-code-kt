package be.edu.adventofcode.y2021

import be.edu.adventofcode.Text

class Day06 {
    fun part1(input: Text, days: Int = 80): Int {
        return part2(input, days).toInt()
    }

    fun part2(input: Text, days: Int = 256): Long {
        val initial = input.get().trim().split(',').map { it.toInt() }
        var fish = LongArray(9)
        for (i in 0..8) fish[i] = initial.count { it == i }.toLong()
        for (day in 1..days) {
            fish = cycle(fish)
        }
        return fish.sum()
    }

    private fun cycle(fish: LongArray): LongArray {
        val next = LongArray(9)
        for (i in 1..8) next[i - 1] = fish[i]
        next[6] += fish[0]
        next[8] = fish[0]
        return next
    }
}
