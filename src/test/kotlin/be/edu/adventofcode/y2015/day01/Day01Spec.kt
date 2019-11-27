package be.edu.adventofcode.y2015.day01

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day01Spec : Spek({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            val floor = day01.part1()
            it("should answer To what floor do the instructions take Santa?") {
                assertEquals(232, floor)
            }
        }
        context("part 2") {
            val position = day01.part2()
            it("should answer What is the position of the character that causes Santa to first enter the basement?") {
                assertEquals(1783, position)
            }
        }
    }
})


