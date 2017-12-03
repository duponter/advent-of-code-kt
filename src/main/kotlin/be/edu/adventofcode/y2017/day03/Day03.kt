package be.edu.adventofcode.y2017.day03

import kotlin.math.abs

class Day03 {
    fun part1(input: Int): Int {
//        println("position for $input")
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

//        println("Drawing $target (between $pair) on $nextPoint from $current: Progress = $progress in one direction of $oneDirection")
        return Triple(target, nextPoint, if (progress == 1 || progress == (oneDirection + 1)) current.third.turn() else current.third)
    }

    fun part2(input: Int): Int {
        return input
    }
}

data class Point(private val x: Int, private val y: Int) {
    constructor() : this(0, 0)

    fun up(): Point = Point(x + 1, y)
    fun down(): Point = Point(x - 1, y)
    fun right(): Point = Point(x, y + 1)
    fun left(): Point = Point(x, y - 1)

    fun distance(other: Point): Int = abs(this.x - other.x) + abs(this.y - other.y)
}

enum class Direction {
    UP {
        override fun apply(current: Point): Point = current.up()

        override fun turn(): Direction = LEFT
    },

    DOWN {
        override fun apply(current: Point): Point = current.down()

        override fun turn(): Direction = RIGHT
    },

    LEFT {
        override fun apply(current: Point): Point = current.left()

        override fun turn(): Direction = DOWN
    },

    RIGHT {
        override fun apply(current: Point): Point = current.right()

        override fun turn(): Direction = UP
    };

    abstract fun apply(current: Point): Point

    abstract fun turn(): Direction
}
