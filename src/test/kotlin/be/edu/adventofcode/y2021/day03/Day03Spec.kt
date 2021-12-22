package be.edu.adventofcode.y2021.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day03Spec : Spek({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("Part 1 - Testcase - What is the power consumption of the submarine?") {
                assertEquals(198, day03.part1(LinesFromArray("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")))
            }
            it("Part 1 - Solution - What is the power consumption of the submarine?") {
                assertEquals(3687446, day03.part1(DayInput().lines(day03)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day03.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day03.part2(DayInput().lines(day03)))
            }
        }
    }
})
