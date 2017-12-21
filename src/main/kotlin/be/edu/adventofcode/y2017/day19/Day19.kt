package be.edu.adventofcode.y2017.day19

import be.edu.adventofcode.Lines

class Day19 {
    fun part1(input: Lines): String {
        val lines = input.get().mapIndexed { r, row -> row.mapIndexed { c, cell -> parse(r, c, cell) } }
                .flatMap { it }
                .filterNotNull()
        val start = lines.first().first
        val map = lines.toMap()

        var result = ""
        var current: Triple<Pair<Int, Int>, Direction, String>? = Triple(start, Direction.DOWN, "")
        while (current != null) {
            result = current.third
            current = go(current, map)
        }

        return result
    }

    private fun go(current: Triple<Pair<Int, Int>, Direction, String>, points: Map<Pair<Int, Int>, Char>): Triple<Pair<Int, Int>, Direction, String>? {
        val instruction = points[current.first] ?: return null
        return when {
            instruction == '+' -> go(Triple(current.second.turnLeft().next(current.first), current.second.turnLeft(), current.third), points) ?: go(Triple(current.second.turnRight().next(current.first), current.second.turnRight(), current.third), points)
            instruction.isLetter() -> Triple(current.second.next(current.first), current.second, current.third.plus(instruction))
            else -> Triple(current.second.next(current.first), current.second, current.third)
        }
    }

    private fun parse(row: Int, col: Int, value: Char): Pair<Pair<Int, Int>, Char>? {
        return if (value != ' ') Pair(Pair(row, col), value) else null
    }

    fun part2(input: Lines): Int {
        val lines = input.get().mapIndexed { r, row -> row.mapIndexed { c, cell -> parse(r, c, cell) } }
                .flatMap { it }
                .filterNotNull()
        println("Lines = ${lines.size}")
        val start = lines.first().first
        val map = lines.toMap()

        var count = 0
        var current: Triple<Pair<Int, Int>, Direction, String>? = Triple(start, Direction.DOWN, "")
        while (current != null) {
            println("$current")
            count++
            current = go(current, map)
        }

        return count
    }
}

private enum class Direction {
    UP {
        override fun next(current: Pair<Int, Int>): Pair<Int, Int> {
            return Pair(current.first - 1, current.second)
        }

        override fun turnLeft(): Direction = LEFT

        override fun turnRight(): Direction = RIGHT
    },
    DOWN {
        override fun next(current: Pair<Int, Int>): Pair<Int, Int> {
            return Pair(current.first + 1, current.second)
        }

        override fun turnLeft(): Direction = RIGHT

        override fun turnRight(): Direction = LEFT
    },
    LEFT {
        override fun next(current: Pair<Int, Int>): Pair<Int, Int> {
            return Pair(current.first, current.second - 1)
        }

        override fun turnLeft(): Direction = DOWN

        override fun turnRight(): Direction = UP
    },
    RIGHT {
        override fun next(current: Pair<Int, Int>): Pair<Int, Int> {
            return Pair(current.first, current.second + 1)
        }

        override fun turnLeft(): Direction = UP

        override fun turnRight(): Direction = DOWN
    };

    abstract fun next(current: Pair<Int, Int>): Pair<Int, Int>

    abstract fun turnLeft(): Direction

    abstract fun turnRight(): Direction
}