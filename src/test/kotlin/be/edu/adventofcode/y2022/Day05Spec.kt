package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        val testInput = LinesFromArray(
            "    [D]",
            "[N] [C]",
            "[Z] [M] [P]",
            " 1   2   3 ",
            "",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
        )
        context("part 1") {
            it("Part 1 - Testcase - After the rearrangement procedure completes, what crate ends up on top of each stack?") {
                day05.part1(testInput) shouldBe "CMZ"
            }
            it("Part 1 - Solution - After the rearrangement procedure completes, what crate ends up on top of each stack?") {
                day05.part1(DayInput().lines(day05)) shouldBe "TWSGQHNHL"
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day05.part2(testInput) shouldBe 1
            }
            it("Part 2 - Solution - ") {
                day05.part2(DayInput().lines(day05)) shouldBe 0
            }
        }
    }
})
