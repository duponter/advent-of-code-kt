package be.edu.adventofcode.y2021.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        val testInput = LinesFromArray(
            "5483143223",
            "2745854711",
            "5264556173",
            "6141336146",
            "6357385478",
            "4167524645",
            "2176841721",
            "6882881134",
            "4846848554",
            "5283751526"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many total flashes are there after 100 steps?") {
                assertEquals(204, day11.part1(testInput, 10))
                assertEquals(1656, day11.part1(testInput))
            }
            it("Part 1 - Solution - How many total flashes are there after 100 steps?") {
                assertEquals(1625, day11.part1(DayInput().lines(day11)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the first step during which all octopuses flash?") {
                assertEquals(195, day11.part2(testInput))
            }
            it("Part 2 - Solution - What is the first step during which all octopuses flash?") {
                assertEquals(244, day11.part2(DayInput().lines(day11)))
            }
        }
    }
})
