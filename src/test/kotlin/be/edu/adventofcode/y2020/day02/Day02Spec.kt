package be.edu.adventofcode.y2020.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day02Spec : Spek({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day02.part1(LinesFromArray("1-3 a: abcde")))
                assertEquals(0, day02.part1(LinesFromArray("1-3 b: cdefg")))
                assertEquals(1, day02.part1(LinesFromArray("2-9 c: ccccccccc")))
            }
            it("How many passwords are valid according to their policies?") {
                assertEquals(378, day02.part1(DayInput().lines(day02)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day02.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day02.part2(DayInput().lines(day02)))
            }
        }
    }
})
