package be.edu.adventofcode.y2020.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day10Spec : Spek({
    describe("day 10") {
        val day10 = Day10()
        context("part 1") {
            it("Part 1 - Testcase 1 - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                assertEquals(35, day10.part1(LinesFromArray("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")))
            }
            it("Part 1 - Testcase 2 - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                assertEquals(220, day10.part1(LinesFromArray("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")))
            }
            it("Part 1 - Solution - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                assertEquals(2470, day10.part1(DayInput().lines(day10)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day10.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day10.part2(DayInput().lines(day10)))
            }
        }
    }
})
