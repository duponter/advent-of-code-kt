package be.edu.adventofcode.y2017.day03

import kotlin.math.abs

class Day03 {
    fun part1(input: Int): Int {
        val sqrt = Math.sqrt(input.toDouble())
        var size = sqrt.toInt()
        if (size < sqrt) {
            size++
        }
        val squares = (0..size).map { it * it }

        return (2..input).fold(Triple(1, Point(), Direction.RIGHT), { current, i -> next(squares, current, i) }).second.distance(Point())
    }

    private fun next(squares: List<Int>, current: Triple<Int, Point, Direction>, target: Int): Triple<Int, Point, Direction> {
        val nextPoint = current.third.apply(current.second)

        val pair = squares.zipWithNext().first { it.second >= target && it.first < target }
        val oneDirection = (pair.second - pair.first - 1) / 2
        val progress = target - pair.first

        return Triple(target, nextPoint, if (progress == 1 || progress == (oneDirection + 1)) current.third.turn() else current.third)
    }

    fun part2(input: Int): Int {
        // max 4 values: vorige value + 3 van rij eronder/erboven/ernaast
        val sqrt = Math.sqrt(input.toDouble())
        var size = sqrt.toInt()
        if (size < 5) {
            size = 5
        } else if (size < sqrt) {
            size++
        }
        val squares = (0..size).map { it * it }
        val saved = mutableMapOf(Pair(Point(), 1))

        var current = Triple(1, Point(), Direction.RIGHT)
        var value = 1

        while (value <= input) {
            current = next(squares, current, current.first + 1)
            value = current.second.surroundingSum(saved, current.third)
        }

        return value
    }
}

data class Point(private val x: Int, private val y: Int) {
    constructor() : this(0, 0)

    fun up(): Point = Point(x + 1, y)
    fun down(): Point = Point(x - 1, y)
    fun right(): Point = Point(x, y + 1)
    fun left(): Point = Point(x, y - 1)

    fun distance(other: Point): Int = abs(this.x - other.x) + abs(this.y - other.y)

    fun surroundingSum(values: MutableMap<Point, Int>, direction: Direction): Int {
        val pointN = direction.back().apply(this)
        val pointW = direction.turn().apply(this)
        val pointNW = direction.turn().turn().apply(pointW)
        val twice = direction.turn().turn().back()
        val pointSW = twice.apply(twice.apply(pointNW))
        val sum = listOf(pointN, pointW, pointNW, pointSW).map { values.getOrDefault(it, 0) }.sum()
        values[this] = sum
        return sum
    }
}

enum class Direction {
    UP {
        override fun apply(current: Point): Point = current.up()

        override fun turn(): Direction = LEFT

        override fun back(): Direction = DOWN
    },

    DOWN {
        override fun apply(current: Point): Point = current.down()

        override fun turn(): Direction = RIGHT

        override fun back(): Direction = UP
    },

    LEFT {
        override fun apply(current: Point): Point = current.left()

        override fun turn(): Direction = DOWN

        override fun back(): Direction = RIGHT
    },

    RIGHT {
        override fun apply(current: Point): Point = current.right()

        override fun turn(): Direction = UP

        override fun back(): Direction = LEFT
    };

    abstract fun apply(current: Point): Point

    abstract fun turn(): Direction

    abstract fun back(): Direction
}