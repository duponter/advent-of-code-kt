package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.Algorithm
import be.edu.adventofcode.GridExploration
import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.Route
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point
import java.util.*

@GridExploration
@Route
@Algorithm("Dijkstra")
class Day15 {
    fun part1(input: Lines): Int {
        val grid: Grid<Int> = Grid(input.digits())

        return crawl(grid, sortedSetOf(Path()))
    }

    private tailrec fun crawl(grid: Grid<Int>, paths: SortedSet<Path>): Int {
        val lowestRisk = paths.minOrNull()!!
        val right = lowestRisk.current.right()
        val down = lowestRisk.current.up()

        var modified: List<Path>
        if (!grid.contains(right)) {
            if (!grid.contains(down)) {
                return lowestRisk.risk
            } else {
                modified = paths.drop(1).plus(lowestRisk.visit(down, grid.value(down)!!))
            }
        } else {
            modified = paths.drop(1).plus(lowestRisk.visit(right, grid.value(right)!!))
            if (grid.contains(down)) {
                modified = modified.plus(lowestRisk.visit(down, grid.value(down)!!))
            }
        }

        return crawl(grid, modified.toSortedSet())
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Path(val visited: Path?, val current: Point, val risk: Int) : Comparable<Path> {
    constructor() : this(null, Point(), 0)

    fun visit(position: Point, riskLevel: Int): Path {
        return Path(this, position, risk + riskLevel)
    }

    override fun compareTo(other: Path): Int {
        return when {
            this.risk != other.risk -> this.risk compareTo other.risk
            this.current != other.current -> this.current compareTo other.current
            this.visited == null -> -1
            other.visited == null -> 1
            else -> this.visited compareTo other.visited
        }
    }
}


fun main() {
    val testInput = LinesFromArray(
        "1163751742",
        "1381373672",
        "2136511328",
        "3694931569",
        "7463417111",
        "1319128137",
        "1359912421",
        "3125421639",
        "1293138521",
        "2311944581"
    )
    println("Day 15, part 1 = ${Day15().part1(testInput)}")
//    println("Day 15, part 2 = ${Day15().part2(testInput)}")
}
