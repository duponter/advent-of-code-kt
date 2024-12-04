package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        val testInput = LinesFromArray(
          ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day05.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day05.part1(DayInput().lines(day05)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day05.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day05.part2(DayInput().lines(day05)) shouldBe 0
            }
        }
    }
})
