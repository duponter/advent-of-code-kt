package be.edu.adventofcode.y2017.day17

import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day17Spec : DescribeSpec({
    describe("day 17") {
        val day17 = Day17()
        context("part 1") {
            it("To short-circuit the spinlock, identify the value that will ultimately be after the last value written (2017)") {
                assertEquals(638, day17.part1(3))
            }
            it("should answer What is the value after 2017 in your completed circular buffer?") {
                assertEquals(808, day17.part1(356))
            }
        }
        context("part 2") {
            it("should answer What is the value after 0 the moment 50000000 is inserted?") {
                assertEquals(47465686, day17.part2(356))
            }
        }
    }
})
