package be.edu.adventofcode.y2021.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day13Spec : Spek({
    describe("day 13") {
        val day13 = Day13()
        val testInput = LinesFromArray(
            "6,10",
            "0,14",
            "9,10",
            "0,3",
            "10,4",
            "4,11",
            "6,0",
            "6,12",
            "4,1",
            "0,13",
            "10,12",
            "3,4",
            "3,0",
            "8,4",
            "1,10",
            "2,14",
            "8,10",
            "9,0",
            "",
            "fold along y=7",
            "fold along x=5"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many dots are visible after completing just the first fold instruction on your transparent paper?") {
                assertEquals(17, day13.part1(testInput))
            }
            xit("Part 1 - Solution - How many dots are visible after completing just the first fold instruction on your transparent paper?") {
                assertEquals(0, day13.part1(DayInput().lines(day13)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day13.part2(testInput))
            }
            xit("Part 2 - Solution - ") {
                assertEquals(0, day13.part2(DayInput().lines(day13)))
            }
        }
    }
})
