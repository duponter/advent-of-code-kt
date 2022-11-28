package be.edu.adventofcode.y2019.day04

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("testcase") {
                day04.valid("111111") shouldBe true
                day04.valid("223450") shouldBe false
                day04.valid("123789") shouldBe false
            }
            it("should answer Part1") {
                day04.part1(TextFromString("165432-707912")) shouldBe 1716
            }
        }
        context("part 2") {
            it("testcase") {
                day04.validNoLargerGroup("112233") shouldBe true
                day04.validNoLargerGroup("123444") shouldBe false
                day04.validNoLargerGroup("111122") shouldBe true
            }
            it("should answer Part2") {
                day04.part2(TextFromString("165432-707912")) shouldBe 1163
            }
        }
    }
})
