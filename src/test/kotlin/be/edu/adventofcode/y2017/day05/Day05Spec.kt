package be.edu.adventofcode.y2017.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("the exit is reached in 5 steps.") {
                day05.part1(LinesFromArray("0", "3", "0", "1", "-3")) shouldBe 5
            }
            it("should answer How many steps does it take to reach the exit?") {
                day05.part1(DayInput().lines(day05)) shouldBe 388611
            }
        }
        context("part 2") {
            it("Using this rule with the above example, the process now takes 10 steps") {
                day05.part2(LinesFromArray("0", "3", "0", "1", "-3")) shouldBe 10
            }
            xit("should answer How many steps does it now take to reach the exit?") {
                day05.part2(DayInput().lines(day05)) shouldBe 27763113
            }
        }
    }
})
