package be.edu.adventofcode.y2017.day14

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day14Spec : DescribeSpec({
    describe("day 14") {
        val day14 = Day14()
        context("part 1") {
            it("In this example, 8108 squares are used across the entire 128x128 grid.") {
                day14.part1(TextFromString("flqrgnkx")) shouldBe 8108
            }
            it("should answer How many squares are used?") {
                day14.part1(TextFromString("ljoxqyyw")) shouldBe 8316
            }
        }
        context("part 2") {
            it("In total, in this example, 1242 regions are present.") {
                day14.part2(TextFromString("flqrgnkx")) shouldBe 1242
            }
            it("should answer How many regions are present given your key string?") {
                day14.part2(TextFromString("ljoxqyyw")) shouldBe 1074
            }
        }
    }
})
