package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        val testInput = LinesFromArray(
            "190: 10 19",
            "3267: 81 40 27",
            "83: 17 5",
            "156: 15 6",
            "7290: 6 8 6 15",
            "161011: 16 10 13",
            "192: 17 8 14",
            "21037: 9 7 18 13",
            "292: 11 6 16 20"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is their total calibration result?") {
                day07.part1(testInput) shouldBe 3749
            }
            it("Part 1 - Solution - What is their total calibration result?") {
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
