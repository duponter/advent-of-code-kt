package be.edu.adventofcode.y2017.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("the spreadsheet's checksum would be 8 + 4 + 6 = 18") {
                day02.part1(LinesFromArray("5 1 9 5", "7 5 3", "2 4 6 8")) shouldBe 18
            }
            it("should answer What is the checksum for the spreadsheet in your puzzle input?") {
                day02.part1(DayInput().lines(day02)) shouldBe 53460
            }
        }
        context("part 2") {
            it("the sum of the results would be 4 + 3 + 2 = 9") {
                day02.part2(LinesFromArray("5 9 2 8", "9 4 7 3", "3 8 6 5")) shouldBe 9
            }
            it("should answer What is the sum of each row's result in your puzzle input?") {
                day02.part2(DayInput().lines(day02)) shouldBe 282
            }
        }
    }
})
