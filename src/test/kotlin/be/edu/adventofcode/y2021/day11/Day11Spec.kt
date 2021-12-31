package be.edu.adventofcode.y2021.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day11Spec : Spek({
    describe("day 11") {
        val day11 = Day11()
        val testInput = LinesFromArray("line")
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day11.part1(testInput))
            }
            it("Part 1 - Solution - ") {
                assertEquals(0, day11.part1(DayInput().lines(day11)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day11.part2(testInput))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day11.part2(DayInput().lines(day11)))
            }
        }
    }
})
