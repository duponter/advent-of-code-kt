package be.edu.adventofcode.y2020.day16

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day16Spec : DescribeSpec({
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
        context("part 2") {
            it("Part 2 - Testcase - What do you get if you multiply those six values together?") {
                assertEquals(mapOf("class" to 12, "row" to 11, "seat" to 13), day16.parsedTicket(TextFromString("class: 0-1 or 4-19\nrow: 0-5 or 8-19\nseat: 0-13 or 16-19\n\nyour ticket:\n11,12,13\n\nnearby tickets:\n3,9,18\n15,1,5\n5,14,9")))
            }
            it("Part 2 - Solution - What do you get if you multiply those six values together?") {
                assertEquals(1346570764607, day16.part2(DayInput().text(day16)))
            }
        }
    }
})
