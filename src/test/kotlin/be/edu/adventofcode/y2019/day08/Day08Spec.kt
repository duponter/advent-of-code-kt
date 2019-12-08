package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day08Spec : Spek({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("On the layer with the fewest 0 digits, what is the number of 1 digits multiplied by the number of 2 digits?") {
                assertEquals(2032, day08.part1(DayInput().text(day08)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day08.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day08.part2(DayInput().text(day08)))
            }
        }
    }
})
