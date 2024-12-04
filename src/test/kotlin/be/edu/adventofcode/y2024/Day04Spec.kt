package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        val testInput = LinesFromArray(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many times does XMAS appear?") {
                day04.part1(testInput) shouldBe 18
            }
            it("Part 1 - Solution - How many times does XMAS appear?") {
                day04.part1(DayInput().lines(day04)) shouldBe 2514
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day04.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day04.part2(DayInput().lines(day04)) shouldBe 0
            }
        }
    }
})
