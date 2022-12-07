package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        val testInput = LinesFromArray(
            ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day08.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day08.part1(DayInput().lines(day08)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day08.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day08.part2(DayInput().lines(day08)) shouldBe 0
            }
        }
    }
})
