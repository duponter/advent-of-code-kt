package be.edu.adventofcode.y2019.day04

import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object Day04Spec : Spek({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("testcase") {
                assertTrue(day04.valid("111111"))
                assertFalse(day04.valid("223450"))
                assertFalse(day04.valid("123789"))
            }
            it("should answer Part1") {
                assertEquals(1716, day04.part1(TextFromString("165432-707912")))
            }
        }
        context("part 2") {
            it("testcase") {
                assertTrue(day04.validNoLargerGroup("112233"))
                assertFalse(day04.validNoLargerGroup("123444"))
                assertTrue(day04.validNoLargerGroup("111122"))
            }
            it("should answer Part2") {
                assertEquals(1163, day04.part2(TextFromString("165432-707912")))
            }
        }
    }
})
