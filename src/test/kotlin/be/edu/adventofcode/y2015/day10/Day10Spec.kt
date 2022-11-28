package be.edu.adventofcode.y2015.day10

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day10Spec : DescribeSpec({
    describe("day 10") {
        val day10 = Day10()
        context("part 1") {
            it("1 becomes 11 (1 copy of digit 1).") {
                day10.lookAndSay("1") shouldBe "11"
            }
            it("11 becomes 21 (2 copies of digit 1).") {
                day10.lookAndSay("11") shouldBe "21"
            }
            it("21 becomes 1211 (one 2 followed by one 1).") {
                day10.lookAndSay("21") shouldBe "1211"
            }
            it("1211 becomes 111221 (one 1, one 2, and two 1s).") {
                day10.lookAndSay("1211") shouldBe "111221"
            }
            it("111221 becomes 312211 (three 1s, two 2s, and one 1).") {
                day10.lookAndSay("111221") shouldBe "312211"
            }
            it("should answer Apply look-and-say 40 times. What is the length of the result?") {
                day10.part1(TextFromString("1113222113")) shouldBe 252594
            }
        }
        context("part 2") {
            it("should answer Apply look-and-say 40 times. What is the length of the result?") {
                day10.part2(TextFromString("1113222113")) shouldBe 3579328
            }
        }
    }
})
