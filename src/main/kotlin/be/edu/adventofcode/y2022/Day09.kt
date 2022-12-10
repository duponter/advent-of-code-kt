package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Direction
import be.edu.adventofcode.grid.Point
import be.edu.adventofcode.grid.PointPlotter
import kotlin.math.max
import kotlin.math.min

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
        val motions = input.get()
            .asSequence()
            .map { Motion.parse(it) }
        val executedSteps = motions.fold(mutableListOf(LargerRope(List(9) { Rope() }))) { ropes, motion -> ropes.addAll(ropes.last().move(motion)); ropes }
        println("${motions.sumOf { it.steps }} steps vs ${executedSteps.size} ropes")
        executedSteps.last().plot()

        val tailPositions = executedSteps.map { it.last().tail }
        PointPlotter().plot(tailPositions.distinct())
        return tailPositions
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
//                println("? TAIL $currentTail follows HEAD $currentHead in direction $direction")
                if (touching(currentHead, currentTail))
                    return currentTail

                if (isDirectlyTwoStepsBetween(currentHead, currentTail))
                    return direction.apply(currentTail)

                var movedTail = if (currentHead.y() > currentTail.y()) currentTail.up() else currentTail.down()
                movedTail = if (currentHead.x() > movedTail.x()) movedTail.right() else movedTail.left()
                println("- TAIL $currentTail follows $currentHead diagonally to $movedTail")

                return movedTail
            }

            private fun touching(first: Point, second: Point): Boolean {
                return horizontalDistance(first, second) < 2 && verticalDistance(first, second) < 2
            }

            private fun isDirectlyTwoStepsBetween(first: Point, second: Point): Boolean {
                return (first.y() == second.y() && horizontalDistance(first, second) == 2) || (first.x() == second.x() && verticalDistance(first, second) == 2)
            }

            private fun horizontalDistance(first: Point, second: Point): Int {
                return max(first.x(), second.x()) - min(first.x(), second.x())
            }

            private fun verticalDistance(first: Point, second: Point): Int {
                return max(first.y(), second.y()) - min(first.y(), second.y())
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
            currentRope.plot()
            return ropes
        }

        private fun move(direction: Direction): LargerRope {
            val first = ropes.first().move(direction)
            println("HEAD moved from ${ropes.first()} to $first")

            return ropes.drop(1)
                .map { it.tail }
                .fold(mutableListOf(first)) { list, tail ->
                    val head = list.last().tail
                    list.add(Rope(head, Rope.followTail(head, tail, direction)))
                    list
                }.toList()
                .let { LargerRope(it) }
        }

        fun last(): Rope = this.ropes.last()

        private fun print() = (ropes.map { it.head } + ropes.last().tail + Point()).forEachIndexed { index, rope -> println("${if (index == 0) "H" else if (index == 10) "s" else index} - $rope") }

        fun plot(plotter: PointPlotter = PointPlotter()) = plotter.plot(this.ropes.map { it.head } + this.ropes.last().tail)
    }
}
