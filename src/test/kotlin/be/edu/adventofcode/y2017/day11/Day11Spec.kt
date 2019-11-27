package be.edu.adventofcode.y2017.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day11Spec : Spek({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("ne,ne,ne is 3 steps away.") {
                assertEquals(3, day11.part1(TextFromString("ne,ne,ne")))
            }
            it("ne,ne,sw,sw is 0 steps away (back where you started).") {
                assertEquals(0, day11.part1(TextFromString("ne,ne,sw,sw")))
            }
            it("ne,ne,s,s is 2 steps away (se,se).") {
                assertEquals(2, day11.part1(TextFromString("ne,ne,s,s")))
            }
            it("se,sw,se,sw,sw is 3 steps away (s,s,sw).") {
                assertEquals(3, day11.part1(TextFromString("se,sw,se,sw,sw")))
            }
            it("should answer How many steps away is he from his starting position?") {
                assertEquals(773, day11.part1(DayInput().text(day11)))
            }
        }
        context("part 2") {
            it("should answer How many steps away is the furthest he ever got from his starting position?") {
                assertEquals(1560, day11.part2(DayInput().text(day11)))
            }
        }
    }
})
