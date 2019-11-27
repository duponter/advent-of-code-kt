package be.edu.adventofcode.y2017.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day08Spec : Spek({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("After this process, the largest value in any register is 1.") {
                assertEquals(1, day08.part1(LinesFromArray("b inc 5 if a > 1",
                        "a inc 1 if b < 5",
                        "c dec -10 if a >= 1",
                        "c inc -20 if c == 10")))
            }
            it("should answer What is the largest value in any register?") {
                assertEquals(5849, day08.part1(DayInput().lines(day08)))
            }
        }
        context("part 2") {
            it("The highest value held in any register during this process is 10") {
                assertEquals(10, day08.part2(LinesFromArray("b inc 5 if a > 1",
                        "a inc 1 if b < 5",
                        "c dec -10 if a >= 1",
                        "c inc -20 if c == 10")))
            }
            it("should answer The highest value held in any register during this process") {
                assertEquals(6702, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
