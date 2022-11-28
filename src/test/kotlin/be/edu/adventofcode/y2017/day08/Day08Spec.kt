package be.edu.adventofcode.y2017.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("After this process, the largest value in any register is 1.") {
                day08.part1(
                    LinesFromArray(
                        "b inc 5 if a > 1",
                        "a inc 1 if b < 5",
                        "c dec -10 if a >= 1",
                        "c inc -20 if c == 10"
                    )
                ) shouldBe 1
            }
            it("should answer What is the largest value in any register?") {
                day08.part1(DayInput().lines(day08)) shouldBe 5849
            }
        }
        context("part 2") {
            it("The highest value held in any register during this process is 10") {
                day08.part2(
                    LinesFromArray(
                        "b inc 5 if a > 1",
                        "a inc 1 if b < 5",
                        "c dec -10 if a >= 1",
                        "c inc -20 if c == 10"
                    )
                ) shouldBe 10
            }
            it("should answer The highest value held in any register during this process") {
                day08.part2(DayInput().lines(day08)) shouldBe 6702
            }
        }
    }
})
