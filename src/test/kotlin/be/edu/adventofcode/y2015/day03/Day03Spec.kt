package be.edu.adventofcode.y2015.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day03Spec : Spek({
    given("day 03") {
        val day03 = Day03()
        on("part 1") {
            it("> delivers presents to 2 houses") {
                assertEquals(2, day03.part1(TextFromString(">")))
            }
            it("^>v< delivers presents to 4 houses") {
                assertEquals(4, day03.part1(TextFromString("^>v<")))
            }
            it("^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses") {
                assertEquals(2, day03.part1(TextFromString("^v^v^v^v^v")))
            }
            it("should answer How many houses receive at least one present?") {
                assertEquals(2081, day03.part1(DayInput().text(day03)))
            }
        }
        on("part 2") {
            it("^v delivers presents to 3 houses") {
                assertEquals(3, day03.part2(TextFromString("^v")))
            }
            it("^>v< delivers presents to 3 houses") {
                assertEquals(3, day03.part2(TextFromString("^>v<")))
            }
            it("^v^v^v^v^v now delivers presents to 11 houses") {
                assertEquals(11, day03.part2(TextFromString("^v^v^v^v^v")))
            }
            it("should answer This year, how many houses receive at least one present?") {
                assertEquals(2341, day03.part2(DayInput().text(day03)))
            }
        }
    }
})
