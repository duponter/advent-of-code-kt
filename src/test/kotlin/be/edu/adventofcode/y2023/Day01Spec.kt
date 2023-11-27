package be.edu.adventofcode.y2023

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        val testInput = LinesFromArray(
          ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day01.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day01.part1(DayInput().lines(day01)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day01.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day01.part2(DayInput().lines(day01)) shouldBe 0
            }
        }
    }
})
