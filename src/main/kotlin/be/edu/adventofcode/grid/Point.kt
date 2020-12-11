package be.edu.adventofcode.grid

import kotlin.math.abs


data class Point(private val x: Int, private val y: Int) {
    constructor() : this(0, 0)
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)

    fun up(): Point = Point(x + 1, y)
    fun down(): Point = Point(x - 1, y)
    fun left(): Point = Point(x, y - 1)
    fun right(): Point = Point(x, y + 1)

    fun coordinates(): Pair<Int, Int> = x to y

    fun distance(other: Point): Int = abs(this.x - other.x) + abs(this.y - other.y)

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