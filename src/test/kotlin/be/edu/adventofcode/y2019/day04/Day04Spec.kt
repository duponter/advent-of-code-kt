package be.edu.adventofcode.y2019.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day04Spec : Spek({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day04.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day04.part1(DayInput().lines(day04)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day04.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day04.part2(DayInput().lines(day04)))
            }
        }
    }
})
