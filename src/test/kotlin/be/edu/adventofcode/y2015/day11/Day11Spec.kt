package be.edu.adventofcode.y2015.day11

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("hijklmmn meets the first requirement but fails the second requirement requirement") {
                day11.meetsRequirements(TextFromString("hijklmmn").get()) shouldBe false
            }
            it("abbceffg meets the third requirement but fails the first requirement.") {
                day11.meetsRequirements(TextFromString("abbceffg").get()) shouldBe false
            }
            it("abbcegjk fails the third requirement, because it only has one double letter (bb).") {
                day11.meetsRequirements(TextFromString("abbcegjk").get()) shouldBe false
            }
            it("The next password after abcdefgh is abcdffaa.") {
                day11.part1(TextFromString("abcdefgh")) shouldBe "abcdffaa"
            }
            it("The next password after ghijklmn is ghjaabcc.") {
                day11.part1(TextFromString("ghijklmn")) shouldBe "ghjaabcc"
            }
            it("should answer What should his next password be?") {
                day11.part1(TextFromString("hxbxwxba")) shouldBe "hxbxxyzz"
            }
        }
        context("part 2") {
            it("should answer Santa's password expired again. What's the next one?") {
                day11.part2(TextFromString("hxbxwxba")) shouldBe "hxcaabcc"
            }
        }
    }
})
