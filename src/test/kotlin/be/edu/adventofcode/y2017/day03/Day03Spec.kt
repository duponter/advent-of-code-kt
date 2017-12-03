package be.edu.adventofcode.y2017.day03

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.xon
import kotlin.test.assertEquals

object Day03Spec : Spek({
    given("day 03") {
        val day03 = Day03()
        on("part 1") {
            it("Data from square 1 is carried 0 steps, since it's at the access port.") {
                assertEquals(0, day03.part1(1))
            }
            it("Data from square 12 is carried 3 steps, such as: down, left, left.") {
                assertEquals(3, day03.part1(12))
            }
            it("Data from square 23 is carried only 2 steps: up twice.") {
                assertEquals(2, day03.part1(23))
            }
            it("Data from square 1024 must be carried 31 steps.") {
                assertEquals(31, day03.part1(1024))
            }
            it("should answer How many steps are required to carry the data from the square identified in your puzzle input all the way to the access port?") {
                assertEquals(430, day03.part1(312051))
            }
        }
        xon("part 2") {
            it("testcase") {
                //                assertEquals(1, day03.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                //                assertEquals(0, day03.part2(DayInput().lines(day03)))
            }
        }
    }
})
