package be.edu.adventofcode.y2017.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day10Spec : DescribeSpec({
    describe("day 10") {
        val day10 = Day10()
        context("part 1") {
            it("The first two numbers in the list end up being 3 and 4; to check the process, you can multiply them together to produce 12.") {
                day10.part1(TextFromString("3, 4, 1, 5"), 5) shouldBe 12
            }
            it("should answer What is the result of multiplying the first two numbers in the list?") {
                day10.part1(DayInput().text(day10), 256) shouldBe 2928
            }
        }
        context("part 2") {
            it("The empty string becomes a2582a3a0e66e6e86e3812dcb672a272.") {
                day10.part2(TextFromString(""), 256) shouldBe "a2582a3a0e66e6e86e3812dcb672a272"
            }
            it("AoC 2017 becomes 33efeb34ea91902bb2f59c9920caa6cd.") {
                day10.part2(TextFromString("AoC 2017"), 256) shouldBe "33efeb34ea91902bb2f59c9920caa6cd"
            }
            it("1,2,3 becomes 3efbe78a8d82f29979031a4aa0b16a9d.") {
                day10.part2(TextFromString("1,2,3"), 256) shouldBe "3efbe78a8d82f29979031a4aa0b16a9d"
            }
            it("1,2,4 becomes 63960835bcdc130f0b66d7ff4f6a5a8e.") {
                day10.part2(TextFromString("1,2,4"), 256) shouldBe "63960835bcdc130f0b66d7ff4f6a5a8e"
            }
            it("should answer What is the Knot Hash of your puzzle input?") {
                day10.part2(DayInput().text(day10), 256) shouldBe "0c2f794b2eb555f7830766bf8fb65a16"
            }
        }
    }
})
