package be.edu.adventofcode.y2021.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("Part 1 - Testcase - How many measurements are larger than the previous measurement?") {
                day01.part1(LinesFromArray("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")) shouldBe 7
            }
            it("Part 1 - Solution - How many measurements are larger than the previous measurement?") {
                day01.part1(DayInput().lines(day01)) shouldBe 1502
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many sums are larger than the previous sum?") {
                day01.part2(LinesFromArray("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")) shouldBe 5
            }
            it("Part 2 - Solution - How many sums are larger than the previous sum?") {
                day01.part2(DayInput().lines(day01)) shouldBe 1538
            }
        }
    }
})
