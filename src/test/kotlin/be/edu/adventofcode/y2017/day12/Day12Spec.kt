package be.edu.adventofcode.y2017.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day12Spec : DescribeSpec({
    describe("day 12") {
        val day12 = Day12()
        context("part 1") {
            it("a total of 6 programs are in this group; all but program 1") {
                assertEquals(
                    6, day12.part1(
                        LinesFromArray(
                            "0 <-> 2",
                            "1 <-> 1",
                            "2 <-> 0, 3, 4",
                            "3 <-> 2, 4",
                            "4 <-> 2, 3, 6",
                            "5 <-> 6",
                        "6 <-> 4, 5")))
            }
            it("should answer How many programs are in the group that contains program ID 0?") {
                assertEquals(145, day12.part1(DayInput().lines(day12)))
            }
        }
        context("part 2") {
            it("should answer How many groups are there in total?") {
                assertEquals(207, day12.part2(DayInput().lines(day12)))
            }
        }
    }
})
