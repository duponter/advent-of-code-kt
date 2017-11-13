package be.edu.adventofcode.y2015.day02

import java.io.File

class Day02 {
    fun part1(): Int {
        return File(this.javaClass.getResource("Day02.txt").toURI()).readLines()
                .map {
                    val split = it.split("x").map { it.toInt() }
                    Present(split.first(), split.elementAt(1), split.last())
                }
                .map { it.surfaceArea() + it.smallestSideArea() }
                .sum()
    }

    fun part2(): Int {
        return File(this.javaClass.getResource("Day02.txt").toURI()).readLines()
                .map {
                    val split = it.split("x").map { it.toInt() }
                    Present(split.first(), split.elementAt(1), split.last())
                }
                .map { it.shortestDistance() + it.volume() }
                .sum()
    }

    private fun <T : Any, R : Any> Iterable<T>.scanLeft(initial: R, operation: (R, T) -> R): List<R> {
        val result = arrayListOf(initial)
        forEach { result.add(operation(result.last(), it)) }
        return result
    }
}

data class Present(val length: Int, val width: Int, val height: Int) {
    fun surfaceArea(): Int = 2 * length * width + 2 * width * height + 2 * height * length

    fun smallestSideArea(): Int = minOf(length * width, width * height, height * length)

    fun shortestDistance(): Int {
        return listOf(length, width, height).sorted().take(2).map { it + it }.sum()
    }

    fun volume(): Int = length * width * height
}
