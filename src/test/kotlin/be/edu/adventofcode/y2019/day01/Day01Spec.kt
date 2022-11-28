package be.edu.adventofcode.y2019.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        xcontext("part 1") {
            it("testcase") {
                day01.part1(LinesFromArray("12")) shouldBe 2
                day01.part1(LinesFromArray("14")) shouldBe 2
                day01.part1(LinesFromArray("1969")) shouldBe 654
                day01.part1(LinesFromArray("100756")) shouldBe 33583
            }
            it("should answer Part1") {
                day01.part1(DayInput().lines(day01)) shouldBe 3481005
            }
        }
        context("part 2") {
            it("testcase") {
                day01.part2(LinesFromArray("14")) shouldBe 2
                day01.part2(LinesFromArray("1969")) shouldBe 966
                day01.part2(LinesFromArray("100756")) shouldBe 50346
            }
            it("should answer Part2") {
                day01.part2(DayInput().lines(day01)) shouldBe 5218616
            }
        }
    }
})
