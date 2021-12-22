package be.edu.adventofcode.y2021.day03

import be.edu.adventofcode.BinaryString
import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.transpose

class Day03 {
    fun part1(input: Lines): Long {
        val gammaRate: BinaryString = input.get()
            .map { it.chunked(1) }
            .transpose()
            .joinToString("") { if (it.count { c -> c == "1" } > it.count { c -> c == "0" }) "1" else "0" }
            .let { BinaryString(it) }
        return gammaRate.toDecimal() * gammaRate.inv().toDecimal()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
