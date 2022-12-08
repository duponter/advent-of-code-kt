package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        val testInput = LinesFromArray(
            "30373",
            "25512",
            "65332",
            "33549",
            "35390"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many trees are visible from outside the grid?") {
                day08.part1(testInput) shouldBe 21
            }
            it("Part 1 - Solution - How many trees are visible from outside the grid?") {
                day08.part1(DayInput().lines(day08)) shouldBe 1708
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the highest scenic score possible for any tree?") {
                day08.part2(testInput) shouldBe 8
            }
            it("Part 2 - Solution - What is the highest scenic score possible for any tree?") {
                day08.part2(DayInput().lines(day08)) shouldBe 504000
            }
        }
    }
})
