package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day07Spec : Spek({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("Max thruster signal from given phase setting sequence") {
                assertEquals(43210, day07.part1(TextFromString("3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0"), listOf(4, 3, 2, 1, 0)))
                assertEquals(54321, day07.part1(TextFromString("3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0"), listOf(0, 1, 2, 3, 4)))
                assertEquals(65210, day07.part1(TextFromString("3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0"), listOf(1, 0, 4, 3, 2)))
            }
            it("What is the highest signal that can be sent to the thrusters?") {
                assertEquals(30940, day07.part1(DayInput().text(day07)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day07.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day07.part2(DayInput().text(day07)))
            }
        }
    }
})
