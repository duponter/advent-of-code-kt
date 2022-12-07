package be.edu.adventofcode.y2021

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
            .flatMap { it.coveredPointsOrthogonally() }
            .groupBy { it }
            .mapValues { it.value.count() }
            .filterValues { it >= 2 }
            .size
    }

    fun part2(input: Lines): Int {
        val destructure = StringDestructure("(\\d+),(\\d+) -> (\\d+),(\\d+)")
        return input.get()
            .map { destructure.many(it) }
            .map { it.map { s -> s.toInt() } }
            .map { Line(Point(it[0], it[1]), Point(it[2], it[3])) }
            .flatMap { it.coveredPointsDiagonally() }
            .groupBy { it }
            .mapValues { it.value.count() }
            .filterValues { it >= 2 }
            .size
    }
}

data class Line(val start: Point, val end: Point) {
    fun coveredPointsDiagonally(): List<Point> {
        val coordinatesStart: Pair<Int, Int> = start.coordinates()
        val coordinatesEnd: Pair<Int, Int> = end.coordinates()

        if (coordinatesStart.first == coordinatesEnd.first || coordinatesStart.second == coordinatesEnd.second) {
            return coveredPointsOrthogonally()
        }

        val rows: IntProgression = if (coordinatesStart.first < coordinatesEnd.first) {
            (coordinatesStart.first..coordinatesEnd.first)
        } else {
            (coordinatesStart.first downTo coordinatesEnd.first)
        }

        val cols: IntProgression = if (coordinatesStart.second < coordinatesEnd.second) {
            (coordinatesStart.second..coordinatesEnd.second)
        } else {
            (coordinatesStart.second downTo coordinatesEnd.second)
        }

        return rows.zip(cols) { r, c -> Point(r, c) }
    }

    fun coveredPointsOrthogonally(): List<Point> {
        val coordinatesStart: Pair<Int, Int> = start.coordinates()
        val coordinatesEnd: Pair<Int, Int> = end.coordinates()

        if (coordinatesStart.first == coordinatesEnd.first) {
            return (if (coordinatesStart.second < coordinatesEnd.second) {
                (coordinatesStart.second..coordinatesEnd.second)
            } else {
                (coordinatesStart.second downTo coordinatesEnd.second)
            }).map { Point(coordinatesStart.first, it) }.toList()
        }

        if (coordinatesStart.second == coordinatesEnd.second) {
            return (if (coordinatesStart.first < coordinatesEnd.first) {
                (coordinatesStart.first..coordinatesEnd.first)
            } else {
                (coordinatesStart.first downTo coordinatesEnd.first)
            }).map { Point(it, coordinatesStart.second) }.toList()
        }

        return emptyList()
    }
}
