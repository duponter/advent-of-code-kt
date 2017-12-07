package be.edu.adventofcode.y2017.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day08Spec : Spek({
    given("day 08") {
        val day08 = Day08()
        on("part 1") {
            it("testcase") {
                assertEquals(1, day08.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
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
