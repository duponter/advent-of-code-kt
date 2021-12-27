package be.edu.adventofcode.y2021.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day10Spec : Spek({
    describe("day 10") {
        val day10 = Day10()
        val testInput = LinesFromArray("line")
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day10.part1(testInput))
            }
            it("Part 1 - Solution - ") {
                assertEquals(0, day10.part1(DayInput().lines(day10)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day10.part2(testInput))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day10.part2(DayInput().lines(day10)))
            }
        }
    }
})
