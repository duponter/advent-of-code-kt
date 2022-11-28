package be.edu.adventofcode.y2017.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("the exit is reached in 5 steps.") {
                assertEquals(5, day05.part1(LinesFromArray("0", "3", "0", "1", "-3")))
            }
            it("should answer How many steps does it take to reach the exit?") {
                assertEquals(388611, day05.part1(DayInput().lines(day05)))
            }
        }
        context("part 2") {
            it("Using this rule with the above example, the process now takes 10 steps") {
                assertEquals(10, day05.part2(LinesFromArray("0", "3", "0", "1", "-3")))
            }
            xit("should answer How many steps does it now take to reach the exit?") {
                assertEquals(27763113, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
