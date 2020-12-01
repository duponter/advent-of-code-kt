package be.edu.adventofcode.y2019.day03

import be.edu.adventofcode.Lines
import java.lang.Integer.sum
import kotlin.math.abs

class Day03 {
    fun part1(input: Lines): Int {
        return wirePath(input.get().first())
                .intersect(wirePath(input.get().last()))
                .map { it.distance() }
                .minOrNull()!!
    }

    private fun wirePath(wire: String): List<Point> {
        return wire.split(',')
                .map { Pair(Direction.valueOf(it.first().toString()), it.drop(1).toInt()) }
                .fold(listOf(Point()), { path: List<Point>, pair: Pair<Direction, Int> -> path.plus(pair.first.path(path.last(), pair.second)) })
                .drop(1)
    }

    fun part2(input: Lines): Int {
        val firstWire = wirePath(input.get().first())
        val secondWire = wirePath(input.get().last())

        return firstWire.intersect(secondWire)
                .map { sum(firstWire.indexOf(it) + 1, secondWire.indexOf(it) + 1) }
                .minOrNull()!!
    }
}

data class Point(val x: Int = 0, val y: Int = 0) {
    fun distance(): Int = distance(Point())

    private fun distance(other: Point): Int = abs(x - other.x) + abs(y - other.y)

    fun up(): Point = Point(x, y + 1)

    fun down(): Point = Point(x, y - 1)

    fun left(): Point = Point(x - 1, y)

    fun right(): Point = Point(x + 1, y)
}

enum class Direction {
    U {
        override fun next(start: Point): Point = start.up()
    },
    D {
        override fun next(start: Point): Point = start.down()
    },
    L {
        override fun next(start: Point): Point = start.left()
    },
    R {
        override fun next(start: Point): Point = start.right()
    };

    abstract fun next(start: Point): Point

    fun path(start: Point, steps: Int): Sequence<Point> {
        return generateSequence(start) { this.next(it) }
                .drop(1)
                .take(steps)
    }
}
