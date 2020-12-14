package be.edu.adventofcode.y2020.day14

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

object Day14Spec : Spek({
    describe("day 14") {
        val day14 = Day14()
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of all values left in memory after it completes?") {
                assertEquals(165, day14.part1(LinesFromArray("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X", "mem[8] = 11", "mem[7] = 101", "mem[8] = 0")))
            }
            it("Part 1 - Solution - What is the sum of all values left in memory after it completes?") {
                assertNotEquals(2047285527, day14.part1(DayInput().lines(day14)))
                assertEquals(12408060320841, day14.part1(DayInput().lines(day14)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day14.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day14.part2(DayInput().lines(day14)))
            }
        }
    }
})
