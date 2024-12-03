package be.edu.adventofcode.y2024

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you add up all of the results of the multiplications?") {
                day03.part1(TextFromString("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")) shouldBe 161
            }
            it("Part 1 - Solution - What do you get if you add up all of the results of the multiplications?") {
                day03.part1(DayInput().text(day03)) shouldBe 166630675
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What do you get if you add up all of the results of just the enabled multiplications?") {
                day03.part2(TextFromString("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")) shouldBe 48
            }
            it("Part 2 - Solution - What do you get if you add up all of the results of just the enabled multiplications?") {
                day03.part2(DayInput().text(day03)) shouldBe 93465710
            }
        }
    }
})
