package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day12Spec : Spek({
    given("day 12") {
        val day12 = Day12()
        on("part 1") {
            it("testcase") {
                assertEquals(1, day12.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day12.part1(DayInput().lines(day12)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day12.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day12.part2(DayInput().lines(day12)))
            }
        }
    }
})
