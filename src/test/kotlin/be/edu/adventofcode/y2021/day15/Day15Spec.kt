package be.edu.adventofcode.y2021.day15

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day15Spec : DescribeSpec({
    describe("day 15") {
        val day15 = Day15()
        val testInput = LinesFromArray(
            "1163751742",
            "1381373672",
            "2136511328",
            "3694931569",
            "7463417111",
            "1319128137",
            "1359912421",
            "3125421639",
            "1293138521",
            "2311944581"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the lowest total risk of any path from the top left to the bottom right?") {
                day15.part1(testInput) shouldBe 40
            }
            xit("Part 1 - Solution - What is the lowest total risk of any path from the top left to the bottom right?") {
                day15.part1(DayInput().lines(day15)) shouldBe 0 //"Did not complete after 1h 15m")
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day15.part2(testInput) shouldBe 1
            }
            xit("Part 2 - Solution - ") {
                day15.part2(DayInput().lines(day15)) shouldBe 0
            }
        }
    }
})
