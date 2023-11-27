package be.edu.adventofcode.y2021

import be.edu.adventofcode.Text
import kotlin.math.abs

class Day07 {
    fun part1(input: Text): Int {
        val crabPositions = input.get().trim().split(',').map { it.toInt() }
        return (0..crabPositions.maxOrNull()!!)
            .minOf { pos -> crabPositions.sumOf { abs(it - pos) } }
    }

    fun part2(input: Text): Int {
        val crabPositions = input.get().trim().split(',').map { it.toInt() }
        val fuelRates: List<Int> = (0..crabPositions.maxOrNull()!!)
            .map { sumNatural(it) }
        return (0..crabPositions.maxOrNull()!!)
            .minOf { pos -> crabPositions.sumOf { fuelRates[abs(it - pos)] } }
    }

    private fun sumNatural(num: Int): Int {
        if (num == 0) {
            return 0
        }
        return num + sumNatural(num - 1)
    }
}
