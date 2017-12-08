package be.edu.adventofcode.y2017.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day09Spec : Spek({
    given("day 09") {
        val day09 = Day09()
        on("part 1") {
            it("testcase") {
                assertEquals(1, day09.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day09.part1(DayInput().lines(day09)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day09.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day09.part2(DayInput().lines(day09)))
            }
        }
    }
})
