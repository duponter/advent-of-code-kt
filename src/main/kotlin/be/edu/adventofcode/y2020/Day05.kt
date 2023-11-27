package be.edu.adventofcode.y2020

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int {
        return seats(input).maxOrNull()!!.toInt()
    }

    fun part2(input: Lines): Int {
        return seats(input).sorted()
            .reduce { acc, next -> if (acc + 1 == next) next else acc }
            .let { it.toInt() + 1 }
    }

    private fun seats(input: Lines): Sequence<Long> = input.get().asSequence()
        .map { it.take(7) to it.takeLast(3) }
        .map {
            it.first.replace('F', '0').replace('B', '1') to
                    it.second.replace('L', '0').replace('R', '1')
        }
        .map { it.first.toLong(2) to it.second.toLong(2) }
        .map { it.first * 8 + it.second }
}
