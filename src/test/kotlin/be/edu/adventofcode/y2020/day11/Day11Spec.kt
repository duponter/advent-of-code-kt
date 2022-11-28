package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("Part 1 - Testcase - How many seats end up occupied?") {
                assertEquals(37, day11.part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
            }
            it("Part 1 - Solution - How many seats end up occupied?") {
                assertEquals(2263, day11.part1(DayInput().lines(day11)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many seats end up occupied?") {
                assertEquals(26, day11.part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
            }
            it("Part 2 - Solution - How many seats end up occupied?") {
                assertEquals(2002, day11.part2(DayInput().lines(day11)))
            }
        }
    }
})
