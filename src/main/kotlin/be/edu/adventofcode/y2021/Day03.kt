package be.edu.adventofcode.y2021

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

    fun part2(input: Lines): Long {
        val oxygenGeneratorRating = BinaryString(filter(input.get(), { ones: List<String>, zeroes: List<String> -> if (ones.size >= zeroes.size) ones else zeroes }, 0))
        val co2ScrubberRating = BinaryString(filter(input.get(), { ones: List<String>, zeroes: List<String> -> if (ones.size >= zeroes.size) zeroes else ones }, 0))
        return oxygenGeneratorRating.toDecimal() * co2ScrubberRating.toDecimal()
    }

    tailrec fun filter(binaryNumbers: List<String>, selector: (List<String>, List<String>) -> List<String>, position: Int): String {
        val (ones, zeroes) = binaryNumbers.partition { it[position] == '1' }
        val keep: List<String> = selector.invoke(ones, zeroes)
        return if (keep.size == 1) {
            keep.first()
        } else {
            filter(keep, selector, position + 1)
        }
    }
}
