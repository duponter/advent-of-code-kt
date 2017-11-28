package be.edu.adventofcode.y2015.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day08Spec : Spek({
    given("day 08") {
        val day08 = Day08();
        on("part 1") {

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
                assertEquals(0, day08.part1(DayInput().lines(day08)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day08.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
