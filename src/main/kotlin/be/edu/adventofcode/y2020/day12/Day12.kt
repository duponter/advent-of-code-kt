package be.edu.adventofcode.y2020.day12

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.Direction
import be.edu.adventofcode.grid.Point

class Day12 {
    fun part1(input: Lines): Int {
        val destructure = StringDestructure("([A-Z])(\\d+)")
        return input.get()
            .map { destructure.pair(it).let { pair -> pair.first.first() to pair.second.toInt() } }
            .fold(Point() to Direction.RIGHT) { acc, nav -> performNavigation(nav, acc) }
            .first.manhattanDistance()
    }

    private fun performNavigation(navigation: Pair<Char, Int>, ship: Pair<Point, Direction>): Pair<Point, Direction> {
        return when (navigation.first) {
            'N' -> ship.first.north(navigation.second) to ship.second
            'S' -> ship.first.south(navigation.second) to ship.second
            'E' -> ship.first.east(navigation.second) to ship.second
            'W' -> ship.first.west(navigation.second) to ship.second
            'L' -> ship.first to ship.second.turn(-navigation.second)
            'R' -> ship.first to ship.second.turn(navigation.second)
            'F' -> ship.second.apply(ship.first, navigation.second) to ship.second
            else -> throw IllegalArgumentException("Action ${navigation.first} is not supported")
        }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
