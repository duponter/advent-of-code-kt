package be.edu.adventofcode.y2017.day05

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int = jump(input.get().map(String::toInt).toTypedArray(), 0, 0)

    private tailrec fun jump(offsets: Array<Int>, index: Int, count: Int): Int {
        val amount = offsets[index]
        offsets[index] = amount + 1
        val next = index + amount
        return if (next >= offsets.size) count + 1 else jump(offsets, next, count + 1)
    }

    fun part2(input: Lines): Int = jump2(input.get().map(String::toInt).toTypedArray(), 0, 0)

    private tailrec fun jump2(offsets: Array<Int>, index: Int, count: Int): Int {
        val amount = offsets[index]
        offsets[index] = if (amount > 2) amount - 1 else amount + 1
        val next = index + amount
        println("Index $index contains $amount, incrementing to ${offsets[index]}, jumping to $next/${offsets.size}")
        return if (next >= offsets.size) count + 1 else jump2(offsets, next, count + 1)
    }
}
