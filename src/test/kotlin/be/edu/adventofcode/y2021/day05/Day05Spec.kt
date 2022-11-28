package be.edu.adventofcode.y2021.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("Part 1 - Testcase - At how many points do at least two lines overlap?") {
                day05.part1(
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
                ) shouldBe 5
            }
            it("Part 1 - Solution - At how many points do at least two lines overlap?") {
                day05.part1(DayInput().lines(day05)) shouldBe 4826
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - At how many points do at least two lines overlap?") {
                day05.part2(
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
                ) shouldBe 12
            }
            it("Part 2 - Solution - At how many points do at least two lines overlap?") {
                day05.part2(DayInput().lines(day05)) shouldBe 16793
            }
        }
    }
})
