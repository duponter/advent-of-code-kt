package be.edu.adventofcode.y2019.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        xcontext("part 1") {
            it("testcase") {
                assertEquals(2, day01.part1(LinesFromArray("12")))
                assertEquals(2, day01.part1(LinesFromArray("14")))
                assertEquals(654, day01.part1(LinesFromArray("1969")))
                assertEquals(33583, day01.part1(LinesFromArray("100756")))
            }
            it("should answer Part1") {
                assertEquals(3481005, day01.part1(DayInput().lines(day01)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(2, day01.part2(LinesFromArray("14")))
                assertEquals(966, day01.part2(LinesFromArray("1969")))
                assertEquals(50346, day01.part2(LinesFromArray("100756")))
            }
            it("should answer Part2") {
                assertEquals(5218616, day01.part2(DayInput().lines(day01)))
            }
        }
    }
})
