package be.edu.adventofcode.y2017.day17

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day17Spec : Spek({
    given("day 17") {
        val day17 = Day17()
        on("part 1") {
            it("To short-circuit the spinlock, identify the value that will ultimately be after the last value written (2017)") {
                assertEquals(638, day17.part1(3))
            }
            it("should answer What is the value after 2017 in your completed circular buffer?") {
                assertEquals(808, day17.part1(356))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day17.part2(3))
            }
            it("should answer Part2") {
                assertEquals(0, day17.part2(356))
            }
        }
    }
})
