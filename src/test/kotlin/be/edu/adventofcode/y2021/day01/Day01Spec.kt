package be.edu.adventofcode.y2021.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day01Spec : Spek({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("Part 1 - Testcase - How many measurements are larger than the previous measurement?") {
                assertEquals(7, day01.part1(LinesFromArray("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")))
            }
            it("Part 1 - Solution - How many measurements are larger than the previous measurement?") {
                assertEquals(1502, day01.part1(DayInput().lines(day01)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day01.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day01.part2(DayInput().lines(day01)))
            }
        }
    }
})
