package be.edu.adventofcode.y2021.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day09.part1(LinesFromArray("line")))
            }
            it("Part 1 - Solution - ") {
                assertEquals(0, day09.part1(DayInput().lines(day09)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day09.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day09.part2(DayInput().lines(day09)))
            }
        }
    }
})
