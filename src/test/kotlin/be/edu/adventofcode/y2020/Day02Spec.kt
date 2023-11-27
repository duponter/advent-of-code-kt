package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("testcase") {
                day02.part1(LinesFromArray("1-3 a: abcde")) shouldBe 1
                day02.part1(LinesFromArray("1-3 b: cdefg")) shouldBe 0
                day02.part1(LinesFromArray("2-9 c: ccccccccc")) shouldBe 1
            }
            it("How many passwords are valid according to their policies?") {
                day02.part1(DayInput().lines(day02)) shouldBe 378
            }
        }
        context("part 2") {
            it("testcase") {
                day02.part1(LinesFromArray("1-3 a: abcde")) shouldBe 1
                day02.part2(LinesFromArray("1-3 b: cdefg")) shouldBe 0
                day02.part2(LinesFromArray("2-9 c: ccccccccc")) shouldBe 0
            }
            it("How many passwords are valid according to the new interpretation of the policies?") {
                day02.part2(DayInput().lines(day02)) shouldBe 280
            }
        }
    }
})
