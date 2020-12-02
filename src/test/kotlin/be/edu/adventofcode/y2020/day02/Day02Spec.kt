package be.edu.adventofcode.y2020.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day02Spec : Spek({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day02.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day02.part1(DayInput().lines(day02)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day02.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day02.part2(DayInput().lines(day02)))
            }
        }
    }
})
