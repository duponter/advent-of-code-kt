package be.edu.adventofcode.y2015.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day07Spec : Spek({
    given("day 07") {
        val day07 = Day07();
        on("part 1") {
            it("testcase") {
                assertEquals(1, day07.part1(LinesFromArray(
                        "123 -> x",
                        "456 -> y",
                        "x AND y -> d",
                        "x OR y -> e",
                        "x LSHIFT 2 -> f",
                        "y RSHIFT 2 -> g",
                        "NOT x -> h",
                        "NOT y -> i"
                )))
            }
            it("should answer What signal is ultimately provided to wire a?") {
                assertEquals(0, day07.part1(DayInput().lines(day07)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day07.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day07.part2(DayInput().lines(day07)))
            }
        }
    }
})
