package be.edu.adventofcode.y2017.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day04Spec : Spek({
    given("day 04") {
        val day04 = Day04()
        on("part 1") {
            it("aa bb cc dd ee is valid.") {
                assertEquals(1, day04.part1(LinesFromArray("aa bb cc dd ee")))
            }
            it("aa bb cc dd aa is not valid - the word aa appears more than once.") {
                assertEquals(0, day04.part1(LinesFromArray("aa bb cc dd aa")))
            }
            it("aa bb cc dd aaa is valid - aa and aaa count as different words.") {
                assertEquals(1, day04.part1(LinesFromArray("aa bb cc dd aaa")))
            }
            it("should answer How many passphrases are valid?") {
                assertEquals(477, day04.part1(DayInput().lines(day04)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day04.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day04.part2(DayInput().lines(day04)))
            }
        }
    }
})
