package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        val testInput = TextFromString(
          "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        )
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you add up all of the results of the multiplications?") {
                day03.part1(testInput) shouldBe 161
            }
            it("Part 1 - Solution - What do you get if you add up all of the results of the multiplications?") {
                day03.part1(DayInput().text(day03)) shouldBe 166630675
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day03.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day03.part2(DayInput().text(day03)) shouldBe 0
            }
        }
    }
})
