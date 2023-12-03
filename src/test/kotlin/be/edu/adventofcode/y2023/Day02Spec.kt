package be.edu.adventofcode.y2023

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        val testInput = LinesFromArray(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of the IDs of those games?") {
                day02.part1(testInput) shouldBe 8
            }
            it("Part 1 - Solution - What is the sum of the IDs of those games?") {
                day02.part1(DayInput().lines(day02)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day02.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day02.part2(DayInput().lines(day02)) shouldBe 0
            }
        }
    }
})
