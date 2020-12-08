package be.edu.adventofcode.y2020.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day08Spec : Spek({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("Testcase - what value is in the accumulator?") {
                assertEquals(5, day08.part1(LinesFromArray("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")))
            }
            it("Solution - what value is in the accumulator?") {
                assertEquals(1810, day08.part1(DayInput().lines(day08)))
            }
        }
        context("part 2") {
            it("Testcase - what value is in the accumulator?") {
                assertEquals(8, day08.part2(LinesFromArray("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4", "acc +6")))
            }
            it("Solution - what value is in the accumulator?") {
                assertEquals(969, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
