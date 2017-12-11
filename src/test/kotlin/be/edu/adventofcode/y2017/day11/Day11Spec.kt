package be.edu.adventofcode.y2017.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day11Spec : Spek({
    given("day 11") {
        val day11 = Day11()
        on("part 1") {
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
            it("should answer Part1") {
                assertEquals(0, day11.part1(DayInput().text(day11)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day11.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day11.part2(DayInput().text(day11)))
            }
        }
    }
})
