package be.edu.adventofcode.y2017.day17

import be.edu.adventofcode.y2017.day10.split

class Day17 {
    fun part1(input: Int): Int {
        val values = spinlock(listOf(0), 0, input)
        return values[values.indexOf(2017) + 1]
    }

    private tailrec fun spinlock(values: List<Int>, current: Int, forward: Int): List<Int> {
        val next = values.forward(current, forward)
        val afterInsert = values.insert(values.size, next)
        return if (afterInsert.size == 2018) afterInsert else spinlock(afterInsert, next, forward)
    }

    fun part2(input: Int): Int {
        return input
    }
}

private fun <T> List<T>.forward(current: Int, forward: Int): Int {
    val next = current + forward
    return 1 + if (next < this.size) next else (next % this.size)
}

private fun <T> List<T>.insert(element: T, index: Int): List<T> {
    val split = this.split(index)
    return split.first.plus(element).plus(split.second)
}
