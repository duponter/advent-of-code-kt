package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("Part 1 - Testcase - What is the first number that does not have this property?") {
                day09.part1(LinesFromArray("35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117", "150", "182", "127", "219", "299", "277", "309", "576"), 5) shouldBe 127
            }
            it("Part 1 - Solution - What is the first number that does not have this property?") {
                day09.part1(DayInput().lines(day09), 25) shouldBe 3199139634
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the encryption weakness in your XMAS-encrypted list of numbers?") {
                day09.part2(LinesFromArray("35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117", "150", "182", "127", "219", "299", "277", "309", "576"), 5) shouldBe 62
            }
            it("Part 2 - Solution - What is the encryption weakness in your XMAS-encrypted list of numbers?") {
                day09.part2(DayInput().lines(day09), 25) shouldBe 438559930
            }
        }
    }
})
