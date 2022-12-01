package be.edu.adventofcode.y2022.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        val testInput = LinesFromArray(
            "1000",
            "2000",
            "3000",
            "",
            "4000",
            "",
            "5000",
            "6000",
            "",
            "7000",
            "8000",
            "9000",
            "",
            "10000",
        )
        context("part 1") {
            it("Part 1 - Testcase - How many total Calories is that Elf carrying?") {
                day01.part1(testInput) shouldBe 24000
            }
            it("Part 1 - Solution - How many total Calories is that Elf carrying?") {
                day01.part1(DayInput().lines(day01)) shouldBe 71124
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many Calories are those Elves carrying in total?") {
                day01.part2(testInput) shouldBe 45000
            }
            it("Part 2 - Solution - ") {
                day01.part2(DayInput().lines(day01)) shouldBe 204639
            }
        }
    }
})
