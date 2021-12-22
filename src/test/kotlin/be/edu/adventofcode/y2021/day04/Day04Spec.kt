package be.edu.adventofcode.y2021.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day04Spec : Spek({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("Part 1 - Testcase - What will your final score be if you choose that board?") {
                assertEquals(
                    4512, day04.part1(
                        LinesFromArray(
                            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
                            "",
                            "22 13 17 11  0",
                            "8  2 23  4 24",
                            "21  9 14 16  7",
                            "6 10  3 18  5",
                            "1 12 20 15 19",
                            "",
                            "3 15  0  2 22",
                            "9 18 13 17  5",
                            "19  8  7 25 23",
                            "20 11 10 24  4",
                            "14 21 16 12  6",
                            "",
                            "14 21 17 24  4",
                            "10 16 15  9 19",
                            "18  8 23 26 20",
                            "22 11 13  6  5",
                            "2  0 12  3  7"
                        )
                    )
                )
            }
            it("Part 1 - Solution - What will your final score be if you choose that board?") {
                assertEquals(67716, day04.part1(DayInput().lines(day04)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - Once it wins, what would its final score be?") {
                assertEquals(
                    1924, day04.part2(
                        LinesFromArray(
                            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
                            "",
                            "22 13 17 11  0",
                            "8  2 23  4 24",
                            "21  9 14 16  7",
                            "6 10  3 18  5",
                            "1 12 20 15 19",
                            "",
                            "3 15  0  2 22",
                            "9 18 13 17  5",
                            "19  8  7 25 23",
                            "20 11 10 24  4",
                            "14 21 16 12  6",
                            "",
                            "14 21 17 24  4",
                            "10 16 15  9 19",
                            "18  8 23 26 20",
                            "22 11 13  6  5",
                            "2  0 12  3  7"
                        )
                    )
                )
            }
            it("Part 2 - Solution - Once it wins, what would its final score be?") {
                assertEquals(0, day04.part2(DayInput().lines(day04)))
            }
        }
    }
})
