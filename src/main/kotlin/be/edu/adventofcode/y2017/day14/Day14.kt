package be.edu.adventofcode.y2017.day14

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2017.day10.KnotHash

class Day14 {
    fun part1(input: Text): Int {
        val hash = KnotHash()
        return (0..127).map { "${input.get()}-$it" }
                .map { hash.calculate(it, 256) }
                .map { it.asIterable().joinToString("") { Integer.toBinaryString(Integer.parseInt(it.toString(), 16)).padStart(4, '0') } }
                .map { it.count { it == '1' } }
                .sum()
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}
