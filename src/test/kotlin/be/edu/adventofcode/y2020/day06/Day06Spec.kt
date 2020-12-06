package be.edu.adventofcode.y2020.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day06Spec : Spek({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day06.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day06.part1(DayInput().lines(day06)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day06.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day06.part2(DayInput().lines(day06)))
            }
        }
    }
})
