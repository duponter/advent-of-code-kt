package be.edu.adventofcode.y2015.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day08Spec : Spek({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {

            it("\"\" is 2 characters of code (the two double quotes), but the string contains zero characters.") {
                assertEquals(2, day08.part1(LinesFromArray("\"\"")))
            }
            it("\"abc\" is 5 characters of code, but 3 characters in the string data.") {
                assertEquals(2, day08.part1(LinesFromArray("\"abc\"")))
            }
            it("\"aaa\\\"aaa\" is 10 characters of code, but the string itself contains six \"a\" characters and a single, escaped quote character, for a total of 7 characters in the string data.") {
                assertEquals(3, day08.part1(LinesFromArray("\"aaa\\\"aaa\"")))
            }
            it("\"\\x27\" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using hexadecimal notation.") {
                assertEquals(5, day08.part1(LinesFromArray("\"\\x27\"")))
            }
            it("should answer What is the number of characters of code for string literals minus the number of characters in memory for the values of the strings?") {
                assertEquals(1333, day08.part1(DayInput().lines(day08)))
            }
        }
        context("part 2") {
            it("\"\" encodes to \"\\\"\\\"\", an increase from 2 characters to 6.") {
                assertEquals(4, day08.part2(LinesFromArray("\"\"")))
            }
            it("\"abc\" encodes to \"\\\"abc\\\"\", an increase from 5 characters to 9.") {
                assertEquals(4, day08.part2(LinesFromArray("\"abc\"")))
            }
            it("\"aaa\\\"aaa\" encodes to \"\\\"aaa\\\\\\\"aaa\\\"\", an increase from 10 characters to 16.") {
                assertEquals(6, day08.part2(LinesFromArray("\"aaa\\\"aaa\"")))
            }
            it("\"\\x27\" encodes to \"\\\"\\\\x27\\\"\", an increase from 6 characters to 11.") {
                assertEquals(5, day08.part2(LinesFromArray("\"\\x27\"")))
            }
            it("should answer What is the total number of characters to represent the newly encoded strings minus the number of characters of code in each original string literal?") {
                assertEquals(2046, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
