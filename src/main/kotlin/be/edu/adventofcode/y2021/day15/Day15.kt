package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point

class Day15 {
    fun part1(input: Lines): Int {
        val grid: Grid<Int> = Grid(input.get().map { line -> line.map { it.digitToInt() } })
        grid.print()

        val paths = crawl(grid, Point())
        println(paths.size)
        return paths.minOrNull() ?: 0
    }

    private fun crawl(grid: Grid<Int>, point: Point): List<Int> {
        val right = point.right()
        val rightValue = grid.value(right)
        val down = point.down()
        val downValue = grid.value(down)

        return if (rightValue == null) {
            if (downValue == null) {
                listOf(0)
            } else {
                crawl(grid, down).map { it + downValue }
            }
        } else {
            val rightCrawl = crawl(grid, right).map { it + rightValue }
            if (downValue == null) {
                rightCrawl
            } else {
                rightCrawl.plus(crawl(grid, down).map { it + downValue })
            }
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
