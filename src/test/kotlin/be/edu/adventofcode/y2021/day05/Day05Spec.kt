package be.edu.adventofcode.y2021.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day05Spec : Spek({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day05.part1(LinesFromArray("line")))
            }
            it("Part 1 - Solution - ") {
                assertEquals(0, day05.part1(DayInput().lines(day05)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day05.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
