package be.edu.adventofcode.y2021.day05

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.Point

class Day05 {
    fun part1(input: Lines): Int {
        val destructure = StringDestructure("(\\d+),(\\d+) -> (\\d+),(\\d+)")
        return input.get()
            .map { destructure.many(it) }
            .map { it.map { s -> s.toInt() } }
            .map { Line(Point(it[0], it[1]), Point(it[2], it[3])) }
            .flatMap { it.coveredPoints() }
            .groupBy { it }
            .mapValues { it.value.count() }
            .filterValues { it >= 2 }
            .size
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Line(val start: Point, val end: Point) {
    fun coveredPoints(): List<Point> {
        val coordinatesStart: Pair<Int, Int> = start.coordinates()
        val coordinatesEnd: Pair<Int, Int> = end.coordinates()

        if (coordinatesStart.first == coordinatesEnd.first) {
            return (if (coordinatesStart.second < coordinatesEnd.second) {
                (coordinatesStart.second..coordinatesEnd.second)
            } else {
                (coordinatesEnd.second..coordinatesStart.second)
            }).map { Point(coordinatesStart.first, it) }.toList()
        }

        if (coordinatesStart.second == coordinatesEnd.second) {
            return (if (coordinatesStart.first < coordinatesEnd.first) {
                (coordinatesStart.first..coordinatesEnd.first)
            } else {
                (coordinatesEnd.first..coordinatesStart.first)
            }).map { Point(it, coordinatesStart.second) }.toList()
        }

        return emptyList()
    }
}
