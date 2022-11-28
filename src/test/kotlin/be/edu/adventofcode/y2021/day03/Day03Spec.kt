package be.edu.adventofcode.y2021.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("Part 1 - Testcase - What is the power consumption of the submarine?") {
                day03.part1(LinesFromArray("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")) shouldBe 198
            }
            it("Part 1 - Solution - What is the power consumption of the submarine?") {
                day03.part1(DayInput().lines(day03)) shouldBe 3687446
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the life support rating of the submarine?") {
                day03.part2(LinesFromArray("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")) shouldBe 230
            }
            it("Part 2 - Solution - What is the life support rating of the submarine?") {
                day03.part2(DayInput().lines(day03)) shouldBe 4406844
            }
        }
    }
})
