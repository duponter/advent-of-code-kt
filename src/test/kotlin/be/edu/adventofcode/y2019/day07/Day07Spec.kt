package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day07Spec : Spek({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day07.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day07.part1(DayInput().lines(day07)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day07.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day07.part2(DayInput().lines(day07)))
            }
        }
    }
})
