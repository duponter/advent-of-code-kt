package be.edu.adventofcode.y2015.day01

import java.io.File

class Day01 {
    fun part1(): Int {
        val input = File(this.javaClass.getResource("Day01.txt").toURI()).readText()
        return input.fold(0, { pos, next -> pos + if (next == '(') 1 else -1 })
    }

    fun part2(): Int {
        val input = File(this.javaClass.getResource("Day01.txt").toURI()).readText()
        return input.asIterable()
                .scanLeft(0, { pos, next -> pos + if (next == '(') 1 else -1 })
                .takeWhile({ it != -1 })
                .size
    }

    private fun <T : Any, R : Any> Iterable<T>.scanLeft(initial: R, operation: (R, T) -> R): List<R> {
        val result = arrayListOf(initial)
        forEach { result.add(operation(result.last(), it)) }
        return result
    }
}
