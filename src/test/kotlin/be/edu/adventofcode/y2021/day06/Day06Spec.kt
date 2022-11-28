package be.edu.adventofcode.y2021.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("Part 1 - Testcase - How many lanternfish would there be after 80 days?") {
                day06.part1(TextFromString("3,4,3,1,2"), 18) shouldBe 26
                day06.part1(TextFromString("3,4,3,1,2")) shouldBe 5934
            }
            it("Part 1 - Solution - How many lanternfish would there be after 80 days?") {
                day06.part1(DayInput().text(day06)) shouldBe 365862
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many lanternfish would there be after 256 days?") {
                day06.part2(TextFromString("3,4,3,1,2")) shouldBe 26984457539
            }
            it("Part 2 - Solution - How many lanternfish would there be after 256 days?") {
                day06.part2(DayInput().text(day06)) shouldBe 1653250886439
            }
        }
    }
})
