package be.edu.adventofcode.y2017.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day01Spec : DescribeSpec({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("1122 produces a sum of 3 (1 + 2)") {
                assertEquals(3, day01.part1(TextFromString("1122")))
            }
            it("1111 produces 4 because each digit (all 1) matches the next.") {
                assertEquals(4, day01.part1(TextFromString("1111")))
            }
            it("1234 produces 0 because no digit matches the next.") {
                assertEquals(0, day01.part1(TextFromString("1234")))
            }
            it("91212129 produces 9 because the only digit that matches the next one is the last digit, 9.") {
                assertEquals(9, day01.part1(TextFromString("91212129")))
            }
            it("should answer What is the solution to your captcha?") {
                assertEquals(1069, day01.part1(DayInput().text(day01)))
            }
        }
        context("part 2") {
            it("1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.") {
                assertEquals(6, day01.part2(TextFromString("1212")))
            }
            it("1221 produces 0, because every comparison is between a 1 and a 2.") {
                assertEquals(0, day01.part2(TextFromString("1221")))
            }
            it("123425 produces 4, because both 2s match each other, but no other digit has a match.") {
                assertEquals(4, day01.part2(TextFromString("123425")))
            }
            it("123123 produces 12.") {
                assertEquals(12, day01.part2(TextFromString("123123")))
            }
            it("12131415 produces 4.") {
                assertEquals(4, day01.part2(TextFromString("12131415")))
            }
            it("should answer What is the solution to your new captcha?") {
                assertEquals(1268, day01.part2(DayInput().text(day01)))
            }
        }
    }
})
