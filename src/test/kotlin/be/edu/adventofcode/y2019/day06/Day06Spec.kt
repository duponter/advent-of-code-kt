package be.edu.adventofcode.y2019.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

object Day06Spec : Spek({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("testcase") {
                assertEquals(42, day06.part1(LinesFromArray("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L")))
            }
            it("What is the total number of direct and indirect orbits in your map data?") {
                assertNotEquals(1709, day06.part1(DayInput().lines(day06)))
                assertEquals(106065, day06.part1(DayInput().lines(day06)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day06.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day06.part2(DayInput().lines(day06)))
            }
        }
    }
})
