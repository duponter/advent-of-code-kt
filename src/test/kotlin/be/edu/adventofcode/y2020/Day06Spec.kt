package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("Answered questions") {
                day06.part1(TextFromString("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb")) shouldBe 11
            }
            it("Part 1 - What is the sum of those counts?") {
                day06.part1(DayInput().text(day06)) shouldBe 6532
            }
        }
        context("part 2") {
            it("Same questions answered") {
                day06.part2(TextFromString("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb")) shouldBe 6
            }
            it("Part 2 - What is the sum of those counts?") {
                day06.part2(DayInput().text(day06)) shouldBe 3427
            }
        }
    }
})
