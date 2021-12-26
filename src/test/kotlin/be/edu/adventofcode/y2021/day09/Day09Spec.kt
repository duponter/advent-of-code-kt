package be.edu.adventofcode.y2021.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        val testInput = LinesFromArray(
            "2199943210",
            "3987894921",
            "9856789892",
            "8767896789",
            "9899965678"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of the risk levels of all low points on your heightmap?") {
                assertEquals(15, day09.part1(testInput))
            }
            it("Part 1 - Solution - What is the sum of the risk levels of all low points on your heightmap?") {
                assertEquals(0, day09.part1(DayInput().lines(day09)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day09.part2(testInput))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day09.part2(DayInput().lines(day09)))
            }
        }
    }
})
