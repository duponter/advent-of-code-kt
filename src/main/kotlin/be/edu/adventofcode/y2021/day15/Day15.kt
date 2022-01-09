package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.Algorithm
import be.edu.adventofcode.BruteForce
import be.edu.adventofcode.GridExploration
import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.Route
import be.edu.adventofcode.grid.Point

@GridExploration
@Route
@BruteForce
@Algorithm("Dijkstra")
class Day15 {
    fun part1(input: Lines): Int {
        return crawl(input.digits(), listOf(Path()))
    }

    private tailrec fun crawl(grid: List<List<Int>>, paths: List<Path>): Int {
        var modified = paths.sorted()
        val lowestRisk = modified.first()
        val right = lowestRisk.current.right()
        val rightValue = right.value(grid)
        val down = lowestRisk.current.up()
        val downValue = down.value(grid)

        if (rightValue == null) {
            if (downValue == null) {
                return lowestRisk.risk
            } else {
                modified = modified.drop(1).plus(lowestRisk.visit(down, downValue))
            }
        } else {
            modified = modified.drop(1).plus(lowestRisk.visit(right, rightValue))
            if (downValue != null) {
                modified = modified.plus(lowestRisk.visit(down, downValue))
            }
        }

        return crawl(grid, modified)
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Path(val visited: Path?, val current: Point, val risk: Int) : Comparable<Path> {
    constructor() : this(null, Point(), 0)

    fun visit(position: Point, riskLevel: Int): Path {
        return Path(this, position, this.risk + riskLevel)
    }

    override fun compareTo(other: Path): Int = this.risk compareTo other.risk

    override fun toString(): String {
        return "Path(current=$current,risk=$risk,previous=${visited?.current}"
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
