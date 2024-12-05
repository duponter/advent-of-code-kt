package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        val testInput = LinesFromArray(
            "47|53",
            "97|13",
            "97|61",
            "97|47",
            "75|29",
            "61|13",
            "75|53",
            "29|13",
            "97|29",
            "53|29",
            "61|53",
            "97|53",
            "61|29",
            "47|13",
            "75|47",
            "97|75",
            "47|61",
            "75|61",
            "47|29",
            "75|13",
            "53|13",
            "",
            "75,47,61,53,29",
            "97,61,53,29,13",
            "75,29,13",
            "75,97,47,61,53",
            "61,13,29",
            "97,13,75,29,47"
        )
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you add up the middle page number from those correctly-ordered updates?") {
                day05.part1(testInput) shouldBe 143
            }
            it("Part 1 - Solution - What do you get if you add up the middle page number from those correctly-ordered updates?") {
                day05.part1(DayInput().lines(day05)) shouldBe 5091
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day05.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day05.part2(DayInput().lines(day05)) shouldBe 0
            }
        }
    }
})
