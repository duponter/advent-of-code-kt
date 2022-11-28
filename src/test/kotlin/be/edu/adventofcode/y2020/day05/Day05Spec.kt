package be.edu.adventofcode.y2020.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class Day05Spec : DescribeSpec({
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
        context("part 2") {
            it("Part 2 - What is the ID of your seat?") {
                assertNotEquals(55, day05.part2(DayInput().lines(day05)))
                assertEquals(504, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
