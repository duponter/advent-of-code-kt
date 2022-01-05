package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day15Spec : Spek({
    describe("day 15") {
        val day15 = Day15()
        val testInput = LinesFromArray("line")
        context("part 1") {
            it("Part 1 - Testcase - ") {
                assertEquals(1, day15.part1(testInput))
            }
            xit("Part 1 - Solution - ") {
                assertEquals(0, day15.part1(DayInput().lines(day15)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day15.part2(testInput))
            }
            xit("Part 2 - Solution - ") {
                assertEquals(0, day15.part2(DayInput().lines(day15)))
            }
        }
    }
})
