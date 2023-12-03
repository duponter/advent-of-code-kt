package be.edu.adventofcode.y2023

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        val testInput = LinesFromArray(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of all of the calibration values?") {
                day01.part1(testInput) shouldBe 142
            }
            it("Part 1 - Solution - What is the sum of all of the calibration values?") {
                day01.part1(DayInput().lines(day01)) shouldBe 55712
            }
        }
        val testInput2 = LinesFromArray(
            "two1nine" +
            "eightwothree" +
            "abcone2threexyz" +
            "xtwone3four" +
            "4nineeightseven2" +
            "zoneight234" +
            "7pqrstsixteen"
        )
        xcontext("part 2") {
            it("Part 2 - Testcase - What is the sum of all of the calibration values?") {
                day01.part2(testInput2) shouldBe 281
            }
            it("Part 2 - Solution - What is the sum of all of the calibration values?") {
                day01.part2(DayInput().lines(day01)) shouldBe 0
            }
        }
    }
})
