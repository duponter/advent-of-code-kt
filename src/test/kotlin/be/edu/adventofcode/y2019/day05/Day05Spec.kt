package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day05Spec : Spek({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("testcase") {
                assertEquals(88, day05.part1(TextFromString("3,0,4,0,99"), 88))
            }
            it("should answer Part1") {
                assertEquals(15314507, day05.part1(DayInput().text(day05), 1))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day05.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day05.part2(DayInput().text(day05)))
            }
        }
    }
})
