package be.edu.adventofcode.y2020

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.Direction
import be.edu.adventofcode.grid.Point

class Day12 {
    fun part1(input: Lines): Int {
        val destructure = StringDestructure("([A-Z])(\\d+)")
        return input.get()
            .map { destructure.pair(it).let { pair -> pair.first.first() to pair.second.toInt() } }
            .fold(Point() to Direction.RIGHT) { acc, nav -> navigate(nav, acc) }
            .first.manhattanDistance(Point())
    }

    private fun navigate(navigation: Pair<Char, Int>, ship: Pair<Point, Direction>): Pair<Point, Direction> {
        val (position, direction) = ship
        return when (navigation.first) {
            'N' -> position.north(navigation.second) to direction
            'S' -> position.south(navigation.second) to direction
            'E' -> position.east(navigation.second) to direction
            'W' -> position.west(navigation.second) to direction
            'L' -> position to direction.turn(-navigation.second)
            'R' -> position to direction.turn(navigation.second)
            'F' -> direction.apply(position, navigation.second) to direction
            else -> throw IllegalArgumentException("Action ${navigation.first} is not supported")
        }
    }

    fun part2(input: Lines): Int {
        val destructure = StringDestructure("([A-Z])(\\d+)")
        return input.get()
            .map { destructure.pair(it).let { pair -> pair.first.first() to pair.second.toInt() } }
            .fold(Point() to Point(10, 1)) { acc, nav -> navigateWithWaypoint(nav, acc) }
            .first.manhattanDistance(Point())
    }

    private fun navigateWithWaypoint(navigation: Pair<Char, Int>, positions: Pair<Point, Point>): Pair<Point, Point> {
        val (ship, waypoint) = positions
        return when (navigation.first) {
            'N' -> ship to waypoint.north(navigation.second)
            'S' -> ship to waypoint.south(navigation.second)
            'E' -> ship to waypoint.east(navigation.second)
            'W' -> ship to waypoint.west(navigation.second)
            'L' -> ship to waypoint.rotate(-navigation.second)
            'R' -> ship to waypoint.rotate(navigation.second)
            'F' -> {
                val (shipX, shipY) = ship.coordinates()
                val (waypointX, waypointY) = waypoint.coordinates()
                Point(shipX + (waypointX * navigation.second), shipY + (waypointY * navigation.second)) to waypoint
            }
            else -> throw IllegalArgumentException("Action ${navigation.first} is not supported")
        }
    }
}
