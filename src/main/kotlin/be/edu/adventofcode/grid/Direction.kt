package be.edu.adventofcode.grid

import kotlin.math.abs

enum class Direction {
    UP {
        override fun apply(current: Point, steps: Int): Point = current.up(steps)

        override fun turnLeft(): Direction = LEFT

        override fun turnRight(): Direction = RIGHT
    },
    DOWN {
        override fun apply(current: Point, steps: Int): Point = current.down(steps)

        override fun turnLeft(): Direction = RIGHT

        override fun turnRight(): Direction = LEFT
    },
    LEFT {
        override fun apply(current: Point, steps: Int): Point = current.left(steps)

        override fun turnLeft(): Direction = DOWN

        override fun turnRight(): Direction = UP
    },
    RIGHT {
        override fun apply(current: Point, steps: Int): Point = current.right(steps)

        override fun turnLeft(): Direction = UP

        override fun turnRight(): Direction = DOWN
    };

    abstract fun apply(current: Point, steps: Int = 1): Point

    abstract fun turnLeft(): Direction

    abstract fun turnRight(): Direction

    fun turn(degrees: Int): Direction {
        if (degrees % 90 != 0) throw IllegalArgumentException("Degrees must be a multiple of 90, $degrees is not")
        val doTurn: (Direction) -> Direction = if (degrees > 0) {
            { it.turnRight() }
        } else {
            { it.turnLeft() }
        }
        return (1..abs(degrees / 90)).fold(this, { acc, _ -> doTurn(acc) })
    }
}
