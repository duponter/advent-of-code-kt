package be.edu.adventofcode.y2019.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day09.part1(LinesFromArray("line")))
            }
            it("What BOOST keycode does it produce?") {
                assertEquals(0, day09.part1(DayInput().lines(day09)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day09.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day09.part2(DayInput().lines(day09)))
            }
        }
    }
})
