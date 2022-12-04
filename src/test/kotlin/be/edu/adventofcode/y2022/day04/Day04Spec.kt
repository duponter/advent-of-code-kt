package be.edu.adventofcode.y2022.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        val testInput = LinesFromArray(
            "2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8"
        )
        context("part 1") {
            it("Part 1 - Testcase - In how many assignment pairs does one range fully contain the other?") {
                day04.part1(testInput) shouldBe 2
            }
            it("Part 1 - Solution - In how many assignment pairs does one range fully contain the other?") {
                day04.part1(DayInput().lines(day04)) shouldBe 485
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - In how many assignment pairs do the ranges overlap?") {
                day04.part2(testInput) shouldBe 4
            }
            it("Part 2 - Solution - In how many assignment pairs do the ranges overlap?") {
                day04.part2(DayInput().lines(day04)) shouldBe 857
            }
        }
    }
})
