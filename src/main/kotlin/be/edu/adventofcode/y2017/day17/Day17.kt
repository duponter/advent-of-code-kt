package be.edu.adventofcode.y2017.day17

import be.edu.adventofcode.y2017.day10.split

class Day17 {
    fun part1(input: Int): Int {
        val values = spinlock(listOf(0), 0, input)
        return values[values.indexOf(2017) + 1]
    }

    private tailrec fun spinlock(values: List<Int>, current: Int, forward: Int): List<Int> {
        val next = forward(current, forward, values.size)
        val afterInsert = values.insert(values.size, next)
        return if (afterInsert.size == 2018) afterInsert else spinlock(afterInsert, next, forward)
    }

    fun part2(input: Int): Int {
        return spinlock2(Pair(0, 1), 1, input, 2).second
    }

    private tailrec fun spinlock2(values: Pair<Int, Int>, current: Int, forward: Int, size: Int): Pair<Int, Int> {
        val next = forward(current, forward, size)
        val afterInsert = when {
            next == values.first + 1 -> Pair(values.first, size)
            next <= values.first -> Pair(values.first + 1, values.second)
            else -> values
        }
        return if (size + 1 == 50000000) afterInsert else spinlock2(afterInsert, next, forward, size + 1)
    }

    private fun forward(current: Int, forward: Int, size: Int): Int {
        val next = current + forward
        return 1 + if (next < size) next else (next % size)
    }
}

private fun <T> List<T>.insert(element: T, index: Int): List<T> {
    val split = this.split(index)
    return split.first.plus(element).plus(split.second)
}
