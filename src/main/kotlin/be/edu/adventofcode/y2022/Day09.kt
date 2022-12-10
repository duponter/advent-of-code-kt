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
            .fold(mutableListOf(Rope())) { ropes, motion -> ropes.addAll(ropes.last().move(motion)); ropes }
            .map { it.tail }
            .distinct()
            .count()
    }

    fun part2(input: Lines): Int {
        return input.get()
            .asSequence()
            .map { Motion.parse(it) }
            .fold(mutableListOf(LargerRope(List(9) { Rope() }))) { ropes, motion -> ropes.addAll(ropes.last().move(motion)); ropes }
            .map { it.last().tail }
            .distinct()
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
    }

    data class Rope(val head: Point = Point(), val tail: Point = Point()) {
        fun move(motion: Motion): List<Rope> {
            var currentRope = this
            val ropes = mutableListOf<Rope>()
            repeat(motion.steps) {
                currentRope = currentRope.move(motion.direction)
                ropes.add(currentRope)
            }
            return ropes
        }

        fun move(direction: Direction): Rope {
            val movedHead = direction.apply(this.head)
            return Rope(movedHead, followTail(movedHead, this.tail, direction));
        }

        companion object {
            fun followTail(currentHead: Point, currentTail: Point, direction: Direction): Point {
                if (touching(currentHead, currentTail))
                    return currentTail

                var movedTail = direction.apply(currentTail)
                println("- $currentTail follows $currentHead going $direction giving $movedTail")
                if (currentHead.manhattanDistance(movedTail) > 1) {
                    val temp = movedTail
                    movedTail = if (direction == Direction.LEFT || direction == Direction.RIGHT)
                        if (currentHead.y() > movedTail.y()) movedTail.up(1) else movedTail.down(1)
                    else
                        if (currentHead.x() > movedTail.x()) movedTail.right(1) else movedTail.left(1)

                    println("-- $temp jumped diagonally to $movedTail")
                }

                return movedTail
            }

            private fun touching(first: Point, second: Point): Boolean {
                return abs(first.x() - second.x()) < 2 && abs(first.y() - second.y()) < 2
            }
        }
    }

    data class LargerRope(val ropes: List<Rope>) {
        fun move(motion: Motion): List<LargerRope> {
            var currentRope = this
            val ropes = mutableListOf<LargerRope>()
            println("$motion")
            repeat(motion.steps) {
                currentRope = currentRope.move(motion.direction)
                ropes.add(currentRope)
            }
            currentRope.print()
            return ropes
        }

        private fun move(direction: Direction): LargerRope {
            val first = ropes.first().move(direction)
            println("HEAD moved to $first")

            val remainingTails = ropes.drop(1).map { it.tail }
            val newRopes = remainingTails.fold(mutableListOf(first)) { list, tail ->
                val head = list.last().tail
                list.add(Rope(head, Rope.followTail(head, tail, direction)))
                list
            }.toList()

            return LargerRope(newRopes)
        }

        fun last(): Rope = this.ropes.last()

        private fun print() = (ropes.map { it.head } + ropes.last().tail + Point()).forEachIndexed { index, rope -> println("${if (index == 0) "H" else if (index == 10) "s" else index} - $rope") }
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
    val third = start.move(Day09.Motion(Direction.LEFT, 3))
    third.forEach { println(it) }
}
