package be.edu.adventofcode.y2017.day20

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day20Spec : DescribeSpec({
    describe("day 20") {
        val day20 = Day20()
        context("part 1") {
            it("testcase") {
                day20.part1(LinesFromArray("line")) shouldBe 1
            }
            it("should answer Part1") {
                day20.part1(DayInput().lines(day20)) shouldBe 0
            }
        }
        context("part 2") {
            it("testcase") {
                day20.part2(LinesFromArray("line")) shouldBe 1
            }
            it("should answer Part2") {
                day20.part2(DayInput().lines(day20)) shouldBe 0
            }
        }
    }
})
