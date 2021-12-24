package be.edu.adventofcode.y2021.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day05Spec : Spek({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("Part 1 - Testcase - At how many points do at least two lines overlap?") {
                assertEquals(
                    5, day05.part1(
                        LinesFromArray(
                            "0,9 -> 5,9",
                            "8,0 -> 0,8",
                            "9,4 -> 3,4",
                            "2,2 -> 2,1",
                            "7,0 -> 7,4",
                            "6,4 -> 2,0",
                            "0,9 -> 2,9",
                            "3,4 -> 1,4",
                            "0,0 -> 8,8",
                            "5,5 -> 8,2",
                        )
                    )
                )
            }
            it("Part 1 - Solution - At how many points do at least two lines overlap?") {
                assertEquals(4826, day05.part1(DayInput().lines(day05)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - At how many points do at least two lines overlap?") {
                assertEquals(
                    12, day05.part2(
                        LinesFromArray(
                            "0,9 -> 5,9",
                            "8,0 -> 0,8",
                            "9,4 -> 3,4",
                            "2,2 -> 2,1",
                            "7,0 -> 7,4",
                            "6,4 -> 2,0",
                            "0,9 -> 2,9",
                            "3,4 -> 1,4",
                            "0,0 -> 8,8",
                            "5,5 -> 8,2",
                        )
                    )
                )
            }
            it("Part 2 - Solution - At how many points do at least two lines overlap?") {
                assertEquals(16793, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
