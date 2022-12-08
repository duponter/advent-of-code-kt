package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    describe("day 09") {
        val day09 = Day09()
        val testInput = LinesFromArray(
            ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day09.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day09.part1(DayInput().lines(day09)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day09.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day09.part2(DayInput().lines(day09)) shouldBe 0
            }
        }
    }
})
