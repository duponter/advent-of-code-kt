package be.edu.adventofcode.y2022.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        val testInput = LinesFromArray(

        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day02.part1(testInput) shouldBe 1
            }
            it("Part 1 - Solution - ") {
                day02.part1(DayInput().lines(day02)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day02.part2(testInput) shouldBe 1
            }
            it("Part 2 - Solution - ") {
                day02.part2(DayInput().lines(day02)) shouldBe 0
            }
        }
    }
})
