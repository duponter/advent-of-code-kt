package be.edu.adventofcode.y2017.day14

import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day14Spec : Spek({
    given("day 14") {
        val day14 = Day14()
        on("part 1") {
            it("In this example, 8108 squares are used across the entire 128x128 grid.") {
                assertEquals(8108, day14.part1(TextFromString("flqrgnkx")))
            }
            it("should answer How many squares are used?") {
                assertEquals(8316, day14.part1(TextFromString("ljoxqyyw")))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day14.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day14.part2(TextFromString("ljoxqyyw")))
            }
        }
    }
})
