package be.edu.adventofcode.y2015.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("> delivers presents to 2 houses") {
                day03.part1(TextFromString(">")) shouldBe 2
            }
            it("^>v< delivers presents to 4 houses") {
                day03.part1(TextFromString("^>v<")) shouldBe 4
            }
            it("^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses") {
                day03.part1(TextFromString("^v^v^v^v^v")) shouldBe 2
            }
            it("should answer How many houses receive at least one present?") {
                day03.part1(DayInput().text(day03)) shouldBe 2081
            }
        }
        context("part 2") {
            it("^v delivers presents to 3 houses") {
                day03.part2(TextFromString("^v")) shouldBe 3
            }
            it("^>v< delivers presents to 3 houses") {
                day03.part2(TextFromString("^>v<")) shouldBe 3
            }
            it("^v^v^v^v^v now delivers presents to 11 houses") {
                day03.part2(TextFromString("^v^v^v^v^v")) shouldBe 11
            }
            it("should answer This year, how many houses receive at least one present?") {
                day03.part2(DayInput().text(day03)) shouldBe 2341
            }
        }
    }
})
