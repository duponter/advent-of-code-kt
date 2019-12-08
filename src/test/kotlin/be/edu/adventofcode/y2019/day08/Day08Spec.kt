package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day08Spec : Spek({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day08.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day08.part1(DayInput().lines(day08)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day08.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
