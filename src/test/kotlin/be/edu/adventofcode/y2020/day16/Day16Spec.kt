package be.edu.adventofcode.y2020.day16

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day16Spec : Spek({
    describe("day 16") {
        val day16 = Day16()
        context("part 1") {
            it("Part 1 - Testcase - What is your ticket scanning error rate?") {
                assertEquals(71, day16.part1(TextFromString("class: 1-3 or 5-7\nrow: 6-11 or 33-44\nseat: 13-40 or 45-50\n\nyour ticket:\n7,1,14\n\nnearby tickets:\n7,3,47\n40,4,50\n55,2,20\n38,6,12")))
            }
            it("Part 1 - Solution - What is your ticket scanning error rate?") {
                assertEquals(22073, day16.part1(DayInput().text(day16)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day16.part2(TextFromString("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day16.part2(DayInput().text(day16)))
            }
        }
    }
})
