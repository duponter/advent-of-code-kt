package be.edu.adventofcode.y2018.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("testcase") {
                assertEquals(3, day01.part1(LinesFromArray("+1", "-2", "+3", "+1")))
                assertEquals(3, day01.part1(LinesFromArray("+1", "+1", "+1")))
                assertEquals(0, day01.part1(LinesFromArray("+1", "+1", "-2")))
                assertEquals(-6, day01.part1(LinesFromArray("-1", "-2", "-3")))
            }
            it("should answer Part1") {
                assertEquals(474, day01.part1(DayInput().lines(day01)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(0, day01.part2(LinesFromArray("+1", "-1")))
//                assertEquals(10, day01.part2(LinesFromArray("+3", "+3", "+4", "-2", "-4")))
//                assertEquals(5, day01.part2(LinesFromArray("-6", "+3", "+8", "+5", "-6")))
//                assertEquals(14, day01.part2(LinesFromArray("+7", "+7", "-2", "-7", "-4")))
            }
            it("should answer Part2") {
                assertEquals(0, day01.part2(DayInput().lines(day01)))
            }
        }
    }
})
