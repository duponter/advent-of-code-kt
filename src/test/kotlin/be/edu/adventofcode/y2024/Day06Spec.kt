package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        val testInput = LinesFromArray(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."
        )
        context("part 1") {
            it("Part 1 - Testcase - How many distinct positions will the guard visit before leaving the mapped area?") {
                day06.part1(testInput) shouldBe 41
            }
            it("Part 1 - Solution - How many distinct positions will the guard visit before leaving the mapped area?") {
                day06.part1(DayInput().lines(day06)) shouldBe 5199
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many different positions could you choose for this obstruction?") {
                day06.part2(testInput) shouldBe 6
            }
            xit("Part 2 - Solution - How many different positions could you choose for this obstruction?") {
                day06.part2(DayInput().lines(day06)) shouldBe 0
            }
        }
    }
})
