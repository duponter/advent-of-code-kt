package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day13Spec : Spek({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("Part 1 - Testcase - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                assertEquals(295, day13.part1(LinesFromArray("939", "7,13,x,x,59,x,31,19")))
            }
            it("Part 1 - Solution - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                assertEquals(0, day13.part1(DayInput().lines(day13)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day13.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day13.part2(DayInput().lines(day13)))
            }
        }
    }
})
