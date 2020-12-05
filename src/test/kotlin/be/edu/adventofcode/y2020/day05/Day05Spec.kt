package be.edu.adventofcode.y2020.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day05Spec : Spek({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("seat IDs for boarding passes") {
                assertEquals(357, day05.part1(LinesFromArray("FBFBBFFRLR")))
                assertEquals(567, day05.part1(LinesFromArray("BFFFBBFRRR")))
                assertEquals(119, day05.part1(LinesFromArray("FFFBBBFRRR")))
                assertEquals(820, day05.part1(LinesFromArray("BBFFBBFRLL")))
            }
            it("Part 1 - What is the highest seat ID on a boarding pass?") {
                assertEquals(878, day05.part1(DayInput().lines(day05)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day05.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
