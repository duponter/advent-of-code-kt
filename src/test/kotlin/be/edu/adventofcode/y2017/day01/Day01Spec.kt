package be.edu.adventofcode.y2017.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("1122 produces a sum of 3 (1 + 2)") {
                day01.part1(TextFromString("1122")) shouldBe 3
            }
            it("1111 produces 4 because each digit (all 1) matches the next.") {
                day01.part1(TextFromString("1111")) shouldBe 4
            }
            it("1234 produces 0 because no digit matches the next.") {
                day01.part1(TextFromString("1234")) shouldBe 0
            }
            it("91212129 produces 9 because the only digit that matches the next one is the last digit, 9.") {
                day01.part1(TextFromString("91212129")) shouldBe 9
            }
            it("should answer What is the solution to your captcha?") {
                day01.part1(DayInput().text(day01)) shouldBe 1069
            }
        }
        context("part 2") {
            it("1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.") {
                day01.part2(TextFromString("1212")) shouldBe 6
            }
            it("1221 produces 0, because every comparison is between a 1 and a 2.") {
                day01.part2(TextFromString("1221")) shouldBe 0
            }
            it("123425 produces 4, because both 2s match each other, but no other digit has a match.") {
                day01.part2(TextFromString("123425")) shouldBe 4
            }
            it("123123 produces 12.") {
                day01.part2(TextFromString("123123")) shouldBe 12
            }
            it("12131415 produces 4.") {
                day01.part2(TextFromString("12131415")) shouldBe 4
            }
            it("should answer What is the solution to your new captcha?") {
                day01.part2(DayInput().text(day01)) shouldBe 1268
            }
        }
    }
})
