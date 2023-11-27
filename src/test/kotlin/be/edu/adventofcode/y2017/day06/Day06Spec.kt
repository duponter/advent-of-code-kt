package be.edu.adventofcode.y2017.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("The infinite loop is detected after the fifth block redistribution cycle") {
                day06.part1(TextFromString("0 2 7 0")) shouldBe 5
            }
            it("should answer How many redistribution cycles must be completed before a configuration is produced that has been seen before?") {
                day06.part1(DayInput().text(day06)) shouldBe 14029
            }
        }
        context("part 2") {
            it(" 2 4 1 2 is seen again after four cycles") {
                day06.part2(TextFromString("0 2 7 0")) shouldBe 4
            }
            it("should answer How many cycles are in the infinite loop that arises from the configuration in your puzzle input?") {
                day06.part2(DayInput().text(day06)) shouldBe 2765
            }
        }
    }
})
