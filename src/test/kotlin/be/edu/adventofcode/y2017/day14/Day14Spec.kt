package be.edu.adventofcode.y2017.day14

import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day14Spec : Spek({
    describe("day 14") {
        val day14 = Day14()
        context("part 1") {
            it("In this example, 8108 squares are used across the entire 128x128 grid.") {
                assertEquals(8108, day14.part1(TextFromString("flqrgnkx")))
            }
            it("should answer How many squares are used?") {
                assertEquals(8316, day14.part1(TextFromString("ljoxqyyw")))
            }
        }
        context("part 2") {
            it("In total, in this example, 1242 regions are present.") {
                assertEquals(1242, day14.part2(TextFromString("flqrgnkx")))
            }
            it("should answer How many regions are present given your key string?") {
                assertEquals(1074, day14.part2(TextFromString("ljoxqyyw")))
            }
        }
    }
})
