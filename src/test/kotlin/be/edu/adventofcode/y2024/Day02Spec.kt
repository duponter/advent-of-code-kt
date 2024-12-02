package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        val testInput = LinesFromArray(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many reports are safe?") {
                day02.part1(testInput) shouldBe 2
            }
            it("Part 1 - Solution - How many reports are safe?") {
                day02.part1(DayInput().lines(day02)) shouldBe 686
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
