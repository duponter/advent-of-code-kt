package be.edu.adventofcode.y2020.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("Testcase - what value is in the accumulator?") {
                day08.part1(LinesFromArray("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")) shouldBe 5
            }
            it("Solution - what value is in the accumulator?") {
                day08.part1(DayInput().lines(day08)) shouldBe 1810
            }
        }
        context("part 2") {
            it("Testcase - what value is in the accumulator?") {
                day08.part2(LinesFromArray("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")) shouldBe 8
            }
            it("Solution - what value is in the accumulator?") {
                day08.part2(DayInput().lines(day08)) shouldBe 969
            }
        }
    }
})
