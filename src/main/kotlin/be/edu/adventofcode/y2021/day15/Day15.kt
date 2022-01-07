package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.*
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point
import kotlin.math.min

@GridExploration
@Route
@Algorithm("Dijkstra")
class Day15 {
    fun part1(input: Lines): Int {
        val grid: Grid<Int> = Grid(input.digits())
        return crawl(grid, Point())
    }

    private fun crawl(grid: Grid<Int>, point: Point): Int {
        val right = point.right()
        val rightValue = grid.value(right)
        fun rightCrawl(): Int {
            return crawl(grid, right) + rightValue!!
        }

        val down = point.up()
        val downValue = grid.value(down)
        fun downCrawl(): Int {
            return crawl(grid, down) + downValue!!
        }

        return if (rightValue == null) {
            if (downValue == null) 0 else downCrawl()
        } else if (downValue == null) {
            rightCrawl()
        } else {
            min(rightCrawl(), downCrawl())
        }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
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
