package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        val testInput = LinesFromArray(
            ""
        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day07.part1(testInput) shouldBe 0
            }
            it("Part 1 - Solution - ") {
                day07.part1(DayInput().lines(day07)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day07.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day07.part2(DayInput().lines(day07)) shouldBe 0
            }
        }
    }
})
