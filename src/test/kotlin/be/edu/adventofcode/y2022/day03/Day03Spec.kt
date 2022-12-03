package be.edu.adventofcode.y2022.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        val testInput = LinesFromArray(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of the priorities of those item types?") {
                day03.part1(testInput) shouldBe 157
            }
            it("Part 1 - Solution - What is the sum of the priorities of those item types?") {
                day03.part1(DayInput().lines(day03)) shouldBe 8018
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the sum of the priorities of those item types?") {
                day03.part2(testInput) shouldBe 70
            }
            it("Part 2 - Solution - What is the sum of the priorities of those item types?") {
                day03.part2(DayInput().lines(day03)) shouldBe 2518
            }
        }
    }
})
