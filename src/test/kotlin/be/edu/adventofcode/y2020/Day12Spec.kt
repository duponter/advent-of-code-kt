package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day12Spec : DescribeSpec({
    describe("day 12") {
        val day12 = Day12()
        context("part 1") {
            it("Part 1 - Testcase - What is the Manhattan distance between that location and the ship's starting position?") {
                day12.part1(LinesFromArray("F10", "N3", "F7", "R90", "F11")) shouldBe 25
            }
            it("Part 1 - Solution - What is the Manhattan distance between that location and the ship's starting position?") {
                day12.part1(DayInput().lines(day12)) shouldBe 1133
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the Manhattan distance between that location and the ship's starting position?") {
                day12.part2(LinesFromArray("F10", "N3", "F7", "R90", "F11")) shouldBe 286
            }
            it("Part 2 - Solution - What is the Manhattan distance between that location and the ship's starting position?") {
                day12.part2(DayInput().lines(day12)) shouldNotBe 56879
                day12.part2(DayInput().lines(day12)) shouldBe 61053
            }
        }
    }
})
