package be.edu.adventofcode.y2017.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day06Spec : Spek({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("The infinite loop is detected after the fifth block redistribution cycle") {
                assertEquals(5, day06.part1(TextFromString("0 2 7 0")))
            }
            it("should answer How many redistribution cycles must be completed before a configuration is produced that has been seen before?") {
                assertEquals(14029, day06.part1(DayInput().text(day06)))
            }
        }
        context("part 2") {
            it(" 2 4 1 2 is seen again after four cycles") {
                assertEquals(4, day06.part2(TextFromString("0 2 7 0")))
            }
            it("should answer How many cycles are in the infinite loop that arises from the configuration in your puzzle input?") {
                assertEquals(2765, day06.part2(DayInput().text(day06)))
            }
        }
    }
})
