package be.edu.adventofcode.y2021.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day07Spec : Spek({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("Part 1 - Testcase - How much fuel must they spend to align to that position?") {
                assertEquals(37, day07.part1(TextFromString("16,1,2,0,4,2,7,1,2,14")))
            }
            it("Part 1 - Solution - How much fuel must they spend to align to that position?") {
                assertEquals(341534, day07.part1(DayInput().text(day07)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How much fuel must they spend to align to that position?") {
                assertEquals(168, day07.part2(TextFromString("16,1,2,0,4,2,7,1,2,14")))
            }
            it("Part 2 - Solution - How much fuel must they spend to align to that position?") {
                assertEquals(93397632, day07.part2(DayInput().text(day07)))
            }
        }
    }
})
