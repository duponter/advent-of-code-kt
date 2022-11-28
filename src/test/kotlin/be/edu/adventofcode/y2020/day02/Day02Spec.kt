package be.edu.adventofcode.y2020.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day02Spec : DescribeSpec({
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
                assertEquals(1, day02.part1(LinesFromArray("1-3 a: abcde")))
                assertEquals(0, day02.part2(LinesFromArray("1-3 b: cdefg")))
                assertEquals(0, day02.part2(LinesFromArray("2-9 c: ccccccccc")))
            }
            it("How many passwords are valid according to the new interpretation of the policies?") {
                assertEquals(280, day02.part2(DayInput().lines(day02)))
            }
        }
    }
})
