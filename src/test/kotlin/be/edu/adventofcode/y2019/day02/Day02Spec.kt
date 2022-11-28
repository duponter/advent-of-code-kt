package be.edu.adventofcode.y2019.day02

import be.edu.adventofcode.DayInput
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("testcase") {
                assertEquals(mutableListOf(2, 0, 0, 0, 99), day02.performOperations(mutableListOf(1, 0, 0, 0, 99)))
                assertEquals(mutableListOf(2, 3, 0, 6, 99), day02.performOperations(mutableListOf(2, 3, 0, 3, 99)))
                assertEquals(mutableListOf(2, 4, 4, 5, 99, 9801), day02.performOperations(mutableListOf(2, 4, 4, 5, 99, 0)))
                assertEquals(mutableListOf(30, 1, 1, 4, 2, 5, 6, 0, 99), day02.performOperations(mutableListOf(1, 1, 1, 4, 99, 5, 6, 0, 99)))
            }
            it("should answer Part1") {
                assertEquals(4930687, day02.part1(DayInput().text(day02)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(19690720, day02.execute(DayInput().text(day02), 53, 35))
            }
            it("should answer Part2") {
                assertEquals(5335, day02.part2(DayInput().text(day02)))
            }
        }
    }
})
