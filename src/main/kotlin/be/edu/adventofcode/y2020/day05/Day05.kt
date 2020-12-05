package be.edu.adventofcode.y2020.day05

import be.edu.adventofcode.Lines
import be.edu.adventofcode.toDecimal

class Day05 {
    fun part1(input: Lines): Int {
        return seats(input).maxOrNull()!!
    }

    fun part2(input: Lines): Int {
        return seats(input).sorted()
            .reduce { acc, next -> if (acc + 1 == next) next else acc } + 1
    }

    private fun seats(input: Lines) = input.asSequence()
        .map { it.take(7) to it.takeLast(3) }
        .map {
            it.first.replace('F', '0').replace('B', '1') to
                    it.second.replace('L', '0').replace('R', '1')
        }
        .map { toDecimal(it.first) to toDecimal(it.second) }
        .map { it.first * 8 + it.second }
}
