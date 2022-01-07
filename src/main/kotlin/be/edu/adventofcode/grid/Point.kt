package be.edu.adventofcode.grid

import kotlin.math.abs

data class Point(private val x: Int, private val y: Int) : Comparable<Point> {
    constructor() : this(0, 0)

    fun up(steps: Int = 1): Point = Point(x, y + steps)

    fun north(steps: Int = 1): Point = up(steps)

    fun down(steps: Int = 1): Point = Point(x, y - steps)

    fun south(steps: Int = 1): Point = down(steps)

    fun left(steps: Int = 1): Point = Point(x - steps, y)

    fun west(steps: Int = 1): Point = left(steps)

    fun right(steps: Int = 1): Point = Point(x + steps, y)

    fun east(steps: Int = 1): Point = right(steps)

    fun coordinates(): Pair<Int, Int> = x to y

    fun manhattanDistance(other: Point): Int = abs(abs(x) - abs(other.x)) + abs(abs(y) - abs(other.y))

    fun rotate(degrees: Int): Point {
        val directionX = if (x < 0) Direction.LEFT else Direction.RIGHT
        val directionY = if (y < 0) Direction.DOWN else Direction.UP
        return directionY.turn(degrees).apply(directionX.turn(degrees).apply(Point(), abs(x)), abs(y))
    }

    override fun compareTo(other: Point): Int = when {
        this.x != other.x -> this.x compareTo other.x
        this.y != other.y -> this.y compareTo other.y
        else -> 0
    }
}
