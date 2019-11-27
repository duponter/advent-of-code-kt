package be.edu.adventofcode.y2015.day10

import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day10Spec : Spek({
    describe("day 10") {
        val day10 = Day10()
        context("part 1") {
            it("1 becomes 11 (1 copy of digit 1).") {
                assertEquals("11", day10.lookAndSay("1"))
            }
            it("11 becomes 21 (2 copies of digit 1).") {
                assertEquals("21", day10.lookAndSay("11"))
            }
            it("21 becomes 1211 (one 2 followed by one 1).") {
                assertEquals("1211", day10.lookAndSay("21"))
            }
            it("1211 becomes 111221 (one 1, one 2, and two 1s).") {
                assertEquals("111221", day10.lookAndSay("1211"))
            }
            it("111221 becomes 312211 (three 1s, two 2s, and one 1).") {
                assertEquals("312211", day10.lookAndSay("111221"))
            }
            it("should answer Apply look-and-say 40 times. What is the length of the result?") {
                assertEquals(252594, day10.part1(TextFromString("1113222113")))
            }
        }
        context("part 2") {
            it("should answer Apply look-and-say 40 times. What is the length of the result?") {
                assertEquals(3579328, day10.part2(TextFromString("1113222113")))
            }
        }
    }
})
