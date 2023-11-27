package be.edu.adventofcode.y2017.day11

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("ne,ne,ne is 3 steps away.") {
                day11.part1(TextFromString("ne,ne,ne")) shouldBe 3
            }
            it("ne,ne,sw,sw is 0 steps away (back where you started).") {
                day11.part1(TextFromString("ne,ne,sw,sw")) shouldBe 0
            }
            it("ne,ne,s,s is 2 steps away (se,se).") {
                day11.part1(TextFromString("ne,ne,s,s")) shouldBe 2
            }
            it("se,sw,se,sw,sw is 3 steps away (s,s,sw).") {
                day11.part1(TextFromString("se,sw,se,sw,sw")) shouldBe 3
            }
            it("should answer How many steps away is he from his starting position?") {
                day11.part1(DayInput().text(day11)) shouldBe 773
            }
        }
        context("part 2") {
            it("should answer How many steps away is the furthest he ever got from his starting position?") {
                day11.part2(DayInput().text(day11)) shouldBe 1560
            }
        }
    }
})
