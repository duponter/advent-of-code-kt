package be.edu.adventofcode.y2015.day01

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day01Spec : Spek({
    given("day 01") {
        val day01 = Day01()
        on("part 1") {
            val floor = day01.part1()
            it("should answer To what floor do the instructions take Santa?") {
                assertEquals(232, floor)
            }
        }
        on("part 2") {
            val position = day01.part2()
            it("should answer What is the position of the character that causes Santa to first enter the basement?") {
                assertEquals(1783, position)
            }
        }
    }
})


