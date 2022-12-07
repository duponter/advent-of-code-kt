package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.Point
import kotlin.math.abs

class Day02 {
    fun part1(input: Lines): Int {
        val destructure = StringDestructure("([a-z]+) (\\d+)")
        return input.get()
            .map { destructure.pair(it).let { pair -> pair.first to pair.second.toInt() } }
            .fold(Point()) { acc, nav -> navigate(acc, nav) }
            .coordinates()
            .let { abs(it.first * it.second) }
    }

    private fun navigate(position: Point, command: Pair<String, Int>): Point {
        return when (command.first) {
            "forward" -> position.right(command.second)
            "up" -> position.up(command.second)
            "down" -> position.down(command.second)
            else -> throw IllegalArgumentException("Command ${command.first} is not supported")
        }
    }

    fun part2(input: Lines): Int {
        val destructure = StringDestructure("([a-z]+) (\\d+)")
        return input.get()
            .map { destructure.pair(it).let { pair -> pair.first to pair.second.toInt() } }
            .fold(0 to Point()) { acc, nav -> navigate(acc, nav) }
            .second.coordinates()
            .let { abs(it.first * it.second) }
    }

    private fun navigate(position: Pair<Int, Point>, command: Pair<String, Int>): Pair<Int, Point> {
        return when (command.first) {
            "forward" -> position.first to position.second.right(command.second).down(position.first * command.second)
            "up" -> position.first - command.second to position.second
            "down" -> position.first + command.second to position.second
            else -> throw IllegalArgumentException("Command ${command.first} is not supported")
        }
    }
}
