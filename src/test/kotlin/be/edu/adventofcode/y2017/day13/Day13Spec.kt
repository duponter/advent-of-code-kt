package be.edu.adventofcode.y2017.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day13Spec : Spek({
    given("day 13") {
        val day13 = Day13()
        on("part 1") {
            it("The trip severity is 0*3 + 6*4 = 24.") {
                assertEquals(24, day13.part1(LinesFromArray("0: 3",
                        "1: 2",
                        "4: 4",
                        "6: 4")))
            }
            it("should answer What is the severity of your whole trip?") {
                assertEquals(1612, day13.part1(DayInput().lines(day13)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day13.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day13.part2(DayInput().lines(day13)))
            }
        }
    }
})
