package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    describe("day 09") {
        val day09 = Day09()
        val testInput = LinesFromArray(
            "R 4",
            "U 4",
            "L 3",
            "D 1",
            "R 4",
            "D 1",
            "L 5",
            "R 2"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many positions does the tail of the rope visit at least once?") {
                day09.part1(testInput) shouldBe 13
            }
            it("Part 1 - Solution - How many positions does the tail of the rope visit at least once?") {
                day09.part1(DayInput().lines(day09)) shouldBe 5981
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many positions does the tail of the rope visit at least once?") {
                day09.part2(testInput) shouldBe 1
            }
            it("Part 2 - Larger Testcase - How many positions does the tail of the rope visit at least once?") {
                day09.part2(
                    LinesFromArray(
                        "R 5",
                        "U 8",
                        "L 8",
                        "D 3",
                        "R 17",
                        "D 10",
                        "L 25",
                        "U 20"
                    )
                ) shouldBe 36
            }
            xit("Part 2 - Solution - How many positions does the tail of the rope visit at least once?") {
                day09.part2(DayInput().lines(day09)) shouldBe 0
            }
        }
    }
})
