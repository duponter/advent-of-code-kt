package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Direction
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point

class Day06 {
    fun part1(input: Lines): Int {
        val grid = Grid(input.get().map { it.toCharArray().toList() })

        val guard = input.get().withIndex().single { it.value.contains('^') }
            .let { Point(it.value.indexOf('^'), it.index) }

        // TODO_EDU change grid to use X & Y-axis correctly (i.e. Going UP en RIGHT)
        var direction = Direction.DOWN
        var current = guard
        var value: Char? = '^'
        val visited = mutableListOf(guard)

        while (value != null) {
            val next = direction.apply(current)
            value = grid.value(next)

            if (value == '#') {
                direction = direction.turnLeft()
            } else if (value != null) {
                current = next
                visited.add(current)
            }
        }

        return visited.distinct().size
    }

    fun part2(input: Lines): Int {
        val grid = Grid(input.get().map { it.toCharArray().toList() })

        val guard = input.get().withIndex().single { it.value.contains('^') }
            .let { Point(it.value.indexOf('^'), it.index) }

        // TODO_EDU change grid to use X & Y-axis correctly (i.e. Going UP en RIGHT)
        var direction = Direction.DOWN
        var current = guard
        var value: Char? = '^'
        val visited = mutableListOf(guard)

        while (value != null) {
            val next = direction.apply(current)
            value = grid.value(next)

            if (value == '#') {
                direction = direction.turnLeft()
            } else if (value != null) {
                current = next
                visited.add(current)
            }
        }

        val counts = visited.groupingBy { it }.eachCount()

        return counts.filterValues { it > 1 }.keys.count()
    }
}
