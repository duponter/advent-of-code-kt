package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Direction
import be.edu.adventofcode.grid.Point
import kotlin.math.abs

class Day09 {
    fun part1(input: Lines): Int {
        return input.get()
            .asSequence()
            .map { Motion.parse(it) }
            .fold(mutableListOf(Rope())) { ropes, motion -> ropes.addAll(motion.execute(ropes.last())); ropes }
            .map { it.tail }
            .distinct()
            .count()
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }

    data class Motion(val direction: Direction, val steps: Int) {
        companion object {
            fun parse(input: String): Motion {
                val tokens = input.split(' ')
                val direction = when (tokens.first()) {
                    "L" -> Direction.LEFT
                    "R" -> Direction.RIGHT
                    "U" -> Direction.UP
                    "D" -> Direction.DOWN
                    else -> throw IllegalArgumentException(tokens.first())
                }
                return Motion(direction, tokens.last().toInt())
            }
        }

        fun execute(rope: Rope): List<Rope> {
            var currentRope = rope
            val ropes = mutableListOf<Rope>()
            repeat(steps) {
                currentRope = currentRope.move(this.direction)
                ropes.add(currentRope)
            }
            return ropes
        }
    }

    data class Rope(val head: Point = Point(), val tail: Point = Point()) {
        fun move(direction: Direction): Rope {
            val movedHead = direction.apply(this.head)
            var movedTail = this.tail
            if (!touching(movedHead, movedTail)) {
                movedTail = direction.apply(movedTail)
                if (movedHead.manhattanDistance(movedTail) > 1) {
                    movedTail = if (direction == Direction.LEFT || direction == Direction.RIGHT)
                        Point(movedTail.x(), movedHead.y())
                    else
                        Point(movedHead.x(), movedTail.y())
                }
            }
            return Rope(movedHead, movedTail);
        }

        private fun touching(first: Point, second: Point): Boolean {
            return abs(first.x() - second.x()) < 2 && abs(first.y() - second.y()) < 2
        }
    }
}

fun main() {
//    val first = Day09.Motion(Direction.RIGHT, 4)
//        .execute(Day09.Rope())
//    first.forEach { println(it) }
//    val second = Day09.Motion(Direction.UP, 4)
//        .execute(first.last())
//    second.forEach { println(it) }
//    val third = Day09.Motion(Direction.LEFT, 3)
//        .execute(second.last())
    val start = Day09.Rope(Point(4, 4), Point(4, 3))
    println(start)
    val third = Day09.Motion(Direction.LEFT, 3)
        .execute(start)
    third.forEach { println(it) }
}
