package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("Part 1 - Testcase - How many seats end up occupied?") {
                day11.part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")) shouldBe 37
            }
            it("Part 1 - Solution - How many seats end up occupied?") {
                day11.part1(DayInput().lines(day11)) shouldBe 2263
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many seats end up occupied?") {
                day11.part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")) shouldBe 26
            }
            it("Part 2 - Solution - How many seats end up occupied?") {
                day11.part2(DayInput().lines(day11)) shouldBe 2002
            }
        }
    }
})
