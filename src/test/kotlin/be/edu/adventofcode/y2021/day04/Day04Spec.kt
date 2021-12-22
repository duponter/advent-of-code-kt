package be.edu.adventofcode.y2021.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day04Spec : Spek({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day04.part1(LinesFromArray("line")))
            }
            it("Part 1 - Solution - ") {
                assertEquals(0, day04.part1(DayInput().lines(day04)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day04.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day04.part2(DayInput().lines(day04)))
            }
        }
    }
})
