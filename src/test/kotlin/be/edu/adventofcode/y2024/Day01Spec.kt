package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        val testInput = LinesFromArray(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the total distance between your lists?") {
                day01.part1(testInput) shouldBe 11
            }
            it("Part 1 - Solution - What is the total distance between your lists?") {
                day01.part1(DayInput().lines(day01)) shouldBe 2756096
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is their similarity score?") {
                day01.part2(testInput) shouldBe 31
            }
            it("Part 2 - Solution - What is their similarity score?") {
                day01.part2(DayInput().lines(day01)) shouldBe 23117829
            }
        }
    }
})
