package be.edu.adventofcode.y2023

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        val testInput = LinesFromArray(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...\$.*....",
            ".664.598.."
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of all of the part numbers in the engine schematic?") {
                day03.part1(testInput) shouldBe 4361
            }
            it("Part 1 - Solution - What is the sum of all of the part numbers in the engine schematic?") {
                val result = day03.part1(DayInput().lines(day03))
                result shouldBeGreaterThan 532992
                result shouldBe 532992
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day03.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day03.part2(DayInput().lines(day03)) shouldBe 0
            }
        }
    }
})
