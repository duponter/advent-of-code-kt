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
        xon("part 1") {
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
        on("part 2") {
            it("Square 1 starts with the value 1.") {
                assertEquals(1, day03.part2(1))
            }
            it("Square 2 has only one adjacent filled square (with value 1), so it also stores 1.") {
                assertEquals(1, day03.part2(2))
            }
            it("Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.") {
                assertEquals(2, day03.part2(3))
            }
            it("Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.") {
                assertEquals(4, day03.part2(4))
            }
            it("Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.") {
                assertEquals(5, day03.part2(5))
            }
            it("should answer What is the first value written that is larger than your puzzle input?") {
                assertEquals(0, day03.part2(312051))
            }
        }
    }
})
