package be.edu.adventofcode.y2021

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day13Spec : DescribeSpec({
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
                day13.part1(testInput) shouldBe 17
            }
            it("Part 1 - Solution - How many dots are visible after completing just the first fold instruction on your transparent paper?") {
                day13.part1(DayInput().lines(day13)) shouldBe 675
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What code do you use to activate the infrared thermal imaging camera system?") {
                day13.part2(testInput)
            }
            it("Part 2 - Solution - What code do you use to activate the infrared thermal imaging camera system?") {
                day13.part2(DayInput().lines(day13))
            }
        }
    }
})
