package be.edu.adventofcode.y2015.day02

import java.io.File

class Day02 {
    fun part1(): Int {
        val input = File(this.javaClass.getResource("Day02.txt").toURI()).readLines()
        return input.size;
    }

    fun part2(): Int {
        val input = File(this.javaClass.getResource("Day02.txt").toURI()).readLines()
        return input.size;
    }

    private fun <T : Any, R : Any> Iterable<T>.scanLeft(initial: R, operation: (R, T) -> R): List<R> {
        val result = arrayListOf(initial)
        forEach { result.add(operation(result.last(), it)) }
        return result
    }
}