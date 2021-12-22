package be.edu.adventofcode.y2021.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day02Spec : Spek({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you multiply your final horizontal position by your final depth?") {
                assertEquals(150, day02.part1(LinesFromArray("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")))
            }
            it("Part 1 - Solution - What do you get if you multiply your final horizontal position by your final depth?") {
                assertEquals(1840243, day02.part1(DayInput().lines(day02)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day02.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day02.part2(DayInput().lines(day02)))
            }
        }
    }
})
