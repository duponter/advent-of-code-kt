package be.edu.adventofcode.y2020.day14

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day14Spec : DescribeSpec({
    describe("day 14") {
        val day14 = Day14()
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of all values left in memory after it completes?") {
                day14.part1(LinesFromArray("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X", "mem[8] = 11", "mem[7] = 101", "mem[8] = 0")) shouldBe 165
            }
            it("Part 1 - Solution - What is the sum of all values left in memory after it completes?") {
                day14.part1(DayInput().lines(day14)) shouldNotBe 2047285527
                day14.part1(DayInput().lines(day14)) shouldBe 12408060320841
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the sum of all values left in memory after it completes?") {
                day14.part2(LinesFromArray("mask = 000000000000000000000000000000X1001X", "mem[42] = 100", "mask = 00000000000000000000000000000000X0XX", "mem[26] = 1")) shouldBe 208
            }
            it("Part 2 - Solution - What is the sum of all values left in memory after it completes?") {
                day14.part2(DayInput().lines(day14)) shouldNotBe 1811431057425
                day14.part2(DayInput().lines(day14)) shouldBe 4466434626828
            }
        }
    }
})
