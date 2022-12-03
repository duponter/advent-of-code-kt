package be.edu.adventofcode.y2022.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        val testInput = LinesFromArray(
            ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day04.part1(testInput) shouldBe 1
            }
            it("Part 1 - Solution - ") {
                day04.part1(DayInput().lines(day04)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day04.part2(testInput) shouldBe 1
            }
            it("Part 2 - Solution - ") {
                day04.part2(DayInput().lines(day04)) shouldBe 0
            }
        }
    }
})
