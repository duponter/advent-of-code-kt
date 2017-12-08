package be.edu.adventofcode.y2015.day03

import be.edu.adventofcode.Text

class Day03 {
    fun part1(input: Text): Int = deliver(input.chars()).toSet().size

    fun part2(input: Text): Int = input.chars()
            .withIndex()    // List<Char> -> List<IndexedValue<Char>>
            .partition { it.index % 2 == 0 } // Pair<List<IndexedValue<Char>>, List<IndexedValue<Char>>>: left = Santa, right = Robo
            .toList()   // List<List<IndexedValue<Char>>>: first = Santa, last = Robo
            .map { it.map { it.value } }    // Unwrap value from IndexedValue: List<List<Char>>
            .map { deliver(it) }    // Execute moves: List<List<Char>> -> List<List<Point>>
            .fold(setOf<Point>(), { set, list -> set.plus(list) }).size

    private fun deliver(input: List<Char>): List<Point> = input
            .fold(listOf(Point(0, 0)), { list, c -> list.plus(list.last().move(c)) })
}

data class Point(private val x: Int, private val y: Int) {
    fun move(direction: Char): Point = when (direction) {
        ('^') -> Point(x, y + 1)
        ('v') -> Point(x, y - 1)
        ('>') -> Point(x + 1, y)
        ('<') -> Point(x - 1, y)
        else -> this
    }
}
