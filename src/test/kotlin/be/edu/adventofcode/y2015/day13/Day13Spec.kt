package be.edu.adventofcode.y2015.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day13Spec : DescribeSpec({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("testcase") {
                day13.part1(LinesFromArray("line")) shouldBe 1
            }
            it("should answer Part1") {
                day13.part1(DayInput().lines(day13)) shouldBe 0
            }
        }
        context("part 2") {
            it("testcase") {
                day13.part2(LinesFromArray("line")) shouldBe 1
            }
            it("should answer Part2") {
                day13.part2(DayInput().lines(day13)) shouldBe 0
            }
        }
    }
})
