package be.edu.adventofcode.y2015.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {

            it("\"\" is 2 characters of code (the two double quotes), but the string contains zero characters.") {
                day08.part1(LinesFromArray("\"\"")) shouldBe 2
            }
            it("\"abc\" is 5 characters of code, but 3 characters in the string data.") {
                day08.part1(LinesFromArray("\"abc\"")) shouldBe 2
            }
            it("\"aaa\\\"aaa\" is 10 characters of code, but the string itself contains six \"a\" characters and a single, escaped quote character, for a total of 7 characters in the string data.") {
                day08.part1(LinesFromArray("\"aaa\\\"aaa\"")) shouldBe 3
            }
            it("\"\\x27\" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using hexadecimal notation.") {
                day08.part1(LinesFromArray("\"\\x27\"")) shouldBe 5
            }
            it("should answer What is the number of characters of code for string literals minus the number of characters in memory for the values of the strings?") {
                day08.part1(DayInput().lines(day08)) shouldBe 1333
            }
        }
        context("part 2") {
            it("\"\" encodes to \"\\\"\\\"\", an increase from 2 characters to 6.") {
                day08.part2(LinesFromArray("\"\"")) shouldBe 4
            }
            it("\"abc\" encodes to \"\\\"abc\\\"\", an increase from 5 characters to 9.") {
                day08.part2(LinesFromArray("\"abc\"")) shouldBe 4
            }
            it("\"aaa\\\"aaa\" encodes to \"\\\"aaa\\\\\\\"aaa\\\"\", an increase from 10 characters to 16.") {
                day08.part2(LinesFromArray("\"aaa\\\"aaa\"")) shouldBe 6
            }
            it("\"\\x27\" encodes to \"\\\"\\\\x27\\\"\", an increase from 6 characters to 11.") {
                day08.part2(LinesFromArray("\"\\x27\"")) shouldBe 5
            }
            it("should answer What is the total number of characters to represent the newly encoded strings minus the number of characters of code in each original string literal?") {
                day08.part2(DayInput().lines(day08)) shouldBe 2046
            }
        }
    }
})
