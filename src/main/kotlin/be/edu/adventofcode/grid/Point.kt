package be.edu.adventofcode.grid

import kotlin.math.abs


data class Point(private val x: Int, private val y: Int) {
    constructor() : this(0, 0)
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)

    fun up(steps: Int = 1): Point = Point(x + steps, y)

    fun north(steps: Int = 1): Point = up(steps)

    fun down(steps: Int = 1): Point = Point(x - steps, y)

    fun south(steps: Int = 1): Point = down(steps)

    fun left(steps: Int = 1): Point = Point(x, y - steps)

    fun west(steps: Int = 1): Point = left(steps)

    fun right(steps: Int = 1): Point = Point(x, y + steps)

    fun east(steps: Int = 1): Point = right(steps)

    fun coordinates(): Pair<Int, Int> = x to y

    fun distance(other: Point): Int = abs(this.x - other.x) + abs(this.y - other.y)

    fun manhattanDistance(): Int = distance(Point())

    fun adjacentPoints(): List<Point> {
        val up = this.up()
        val down = this.down()
        return listOf(
            up.left(), up, up.right(),
            left(), right(),
            down.left(), down, down.right(),
        )
    }

}