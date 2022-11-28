package be.edu.adventofcode.y2017.day17

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day17Spec : DescribeSpec({
    describe("day 17") {
        val day17 = Day17()
        context("part 1") {
            it("To short-circuit the spinlock, identify the value that will ultimately be after the last value written (2017)") {
                day17.part1(3) shouldBe 638
            }
            it("should answer What is the value after 2017 in your completed circular buffer?") {
                day17.part1(356) shouldBe 808
            }
        }
        context("part 2") {
            it("should answer What is the value after 0 the moment 50000000 is inserted?") {
                day17.part2(356) shouldBe 47465686
            }
        }
    }
})
