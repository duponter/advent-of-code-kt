package be.edu.adventofcode.y2020.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("Part 1 - Testcase - What is the first number that does not have this property?") {
                assertEquals(127, day09.part1(LinesFromArray("35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117", "150", "182", "127", "219", "299", "277", "309", "576"), 5))
            }
            it("Part 1 - Solution - What is the first number that does not have this property?") {
                assertEquals(3199139634, day09.part1(DayInput().lines(day09), 25))
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
