package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day12Spec : Spek({
    given("day 12") {
        val day12 = Day12()
        on("part 1") {
            it("[1,2,3] and {\"a\":2,\"b\":4} both have a sum of 6.") {
                assertEquals(6, day12.part1(TextFromString("[1,2,3]")))
                assertEquals(6, day12.part1(TextFromString("{\"a\":2,\"b\":4}")))
            }
            it("[[[3]]] and {\"a\":{\"b\":4},\"c\":-1} both have a sum of 3.") {
                assertEquals(3, day12.part1(TextFromString("[[[3]]]")))
                assertEquals(3, day12.part1(TextFromString("{\"a\":{\"b\":4},\"c\":-1}")))
            }
            it("{\"a\":[-1,1]} and [-1,{\"a\":1}] both have a sum of 0.") {
                assertEquals(0, day12.part1(TextFromString("{\"a\":[-1,1]}")))
                assertEquals(0, day12.part1(TextFromString("[-1,{\"a\":1}]")))
            }
            it("[] and {} both have a sum of 0.") {
                assertEquals(0, day12.part1(TextFromString("[]")))
                assertEquals(0, day12.part1(TextFromString("{}")))
            }
            it("should answer What is the sum of all numbers in the document?") {
                assertEquals(0, day12.part1(DayInput().text(day12)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day12.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day12.part2(DayInput().text(day12)))
            }
        }
    }
})
