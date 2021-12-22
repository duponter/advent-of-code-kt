package be.edu.adventofcode.y2021.day03

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.transpose
import be.edu.adventofcode.toDecimal

class Day03 {
    fun part1(input: Lines): Long {
        val matrix: Matrix<String> = input.get()
            .map { it.chunked(1) }
        val gammaRate: String = matrix.transpose().joinToString("") { if (it.count { c -> c == "1" } > it.count { c -> c == "0" }) "1" else "0" }
        val epsilonRate = gammaRate.chunked(1) { it.first().digitToInt() }.map { it + 1 }.joinToString("").replace('2', '0')
        return toDecimal(gammaRate) * toDecimal(epsilonRate)
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
