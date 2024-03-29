package be.edu.adventofcode.y2021

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day14Spec : DescribeSpec({
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
                day14.part1(testInput) shouldBe 1588
            }
            it("Part 1 - Solution - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                day14.part1(DayInput().lines(day14)) shouldBe 2947
            }
        }
        context("part 2") {
            it("Part 2 - Testcase 10 steps - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                day14.part2(testInput, 10) shouldBe 1588
                day14.part2(DayInput().lines(day14), 10) shouldBe 2947
            }
            it("Part 2 - Testcase - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                day14.part2(testInput) shouldBe 2188189693529
            }
            it("Part 2 - Solution - What do you get if you take the quantity of the most common element and subtract the quantity of the least common element?") {
                day14.part2(DayInput().lines(day14)) shouldBe 3232426226464
            }
        }
    }
})
