package be.edu.adventofcode.y2021.day14

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day14Spec : Spek({
    describe("day 14") {
        val day14 = Day14()
        val testInput = LinesFromArray(
            "NNCB",
            "",
            "CH -> B",
            "HH -> N",
            "CB -> H",
            "NH -> C",
            "HB -> C",
            "HC -> B",
            "HN -> C",
            "NN -> C",
            "BH -> H",
            "NC -> B",
            "NB -> B",
            "BN -> B",
            "BB -> N",
            "BC -> B",
            "CC -> N",
            "CN -> C"
        )
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                assertEquals(1588, day14.part1(testInput))
            }
            it("Part 1 - Solution - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                assertEquals(2947, day14.part1(DayInput().lines(day14)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase 10 steps - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                assertEquals(1588, day14.part2(testInput, 10))
                assertEquals(2947, day14.part2(DayInput().lines(day14), 10))
            }
            it("Part 2 - Testcase - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                assertEquals(2188189693529, day14.part2(testInput))
            }
            it("Part 2 - Solution - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                assertEquals(3232426226464, day14.part2(DayInput().lines(day14)))
            }
        }
    }
})
