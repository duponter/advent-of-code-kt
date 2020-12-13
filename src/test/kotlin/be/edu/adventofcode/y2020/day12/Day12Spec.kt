package be.edu.adventofcode.y2020.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day12Spec : Spek({
    describe("day 12") {
        val day12 = Day12()
        context("part 1") {
            it("Part 1 - Testcase - What is the Manhattan distance between that location and the ship's starting position?") {
                assertEquals(25, day12.part1(LinesFromArray("F10", "N3", "F7", "R90", "F11")))
            }
            it("Part 1 - Solution - What is the Manhattan distance between that location and the ship's starting position?") {
                assertEquals(0, day12.part1(DayInput().lines(day12)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day12.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day12.part2(DayInput().lines(day12)))
            }
        }
    }
})
