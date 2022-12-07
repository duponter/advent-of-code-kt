package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("Multiplying two entries that sum to 2020 (1721 and 299) = 514579") {
                day01.part1(LinesFromArray("1721", "979", "366", "299", "675", "1456")) shouldBe 514579
            }
            it("should answer Part1") {
                day01.part1(DayInput().lines(day01)) shouldBe 633216
            }
        }
        context("part 2") {
            it("Multiplying three entries that sum to 2020 (979, 366, and 675) = 241861950") {
                day01.part2(LinesFromArray("1721", "979", "366", "299", "675", "1456")) shouldBe 241861950
            }
            it("should answer Part2") {
                day01.part2(DayInput().lines(day01)) shouldBe 68348924
            }
        }
    }
})
