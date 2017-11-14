package be.edu.adventofcode.y2015.day03

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day03Spec : Spek({
    given("day 03") {
        val day03 = Day03();
        on("part 1") {
            val answer = day03.part1()
            it("should answer Part1") {
                assertEquals(0, answer)
            }
        }
        on("part 2") {
            val answer = day03.part2()
            it("should answer Part2") {
                assertEquals(0, answer)
            }
        }
    }
})
