package be.edu.adventofcode.y2018.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("testcase") {
                day01.part1(LinesFromArray("+1", "-2", "+3", "+1")) shouldBe 3
                day01.part1(LinesFromArray("+1", "+1", "+1")) shouldBe 3
                day01.part1(LinesFromArray("+1", "+1", "-2")) shouldBe 0
                day01.part1(LinesFromArray("-1", "-2", "-3")) shouldBe -6
            }
            it("should answer Part1") {
                day01.part1(DayInput().lines(day01)) shouldBe 474
            }
        }
        context("part 2") {
            it("testcase") {
                day01.part2(LinesFromArray("+1", "-1")) shouldBe 0
//                day01.part2(LinesFromArray("+3", "+3", "+4", "-2", "-4")) shouldBe 10
//                day01.part2(LinesFromArray("-6", "+3", "+8", "+5", "-6")) shouldBe 5
//                day01.part2(LinesFromArray("+7", "+7", "-2", "-7", "-4")) shouldBe 14
            }
            it("should answer Part2") {
                day01.part2(DayInput().lines(day01)) shouldBe 0
            }
        }
    }
})
