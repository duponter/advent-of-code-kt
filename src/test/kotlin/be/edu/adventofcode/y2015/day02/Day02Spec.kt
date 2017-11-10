package be.edu.adventofcode.y2015.day02

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day02Spec : Spek({
    given("day 02") {
        val day02 = Day02();
        on("part 1") {
            val floor = day02.part1()
            it("should answer How many total square feet of wrapping paper should they order?") {
                assertEquals(1000, floor)
            }
        }
        on("part 2") {
            val position = day02.part2()
            it("should answer What is the position of the character that causes Santa to first enter the basement?") {
                assertEquals(1000, position)
            }
        }
    }
})