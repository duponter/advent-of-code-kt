package be.edu.adventofcode.y2015.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day13Spec : DescribeSpec({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day13.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day13.part1(DayInput().lines(day13)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day13.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day13.part2(DayInput().lines(day13)))
            }
        }
    }
})
