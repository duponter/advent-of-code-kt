package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        val testInput = LinesFromArray(
          ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day06.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day06.part1(DayInput().lines(day06)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day06.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day06.part2(DayInput().lines(day06)) shouldBe 0
            }
        }
    }
})
