package be.edu.adventofcode.y2015.day11

import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day11Spec : Spek({
    describe("day 11") {
        val day11 = Day11()
        context("part 1") {
            it("hijklmmn meets the first requirement but fails the second requirement requirement") {
                assertEquals(false, day11.meetsRequirements(TextFromString("hijklmmn").get()))
            }
            it("abbceffg meets the third requirement but fails the first requirement.") {
                assertEquals(false, day11.meetsRequirements(TextFromString("abbceffg").get()))
            }
            it("abbcegjk fails the third requirement, because it only has one double letter (bb).") {
                assertEquals(false, day11.meetsRequirements(TextFromString("abbcegjk").get()))
            }
            it("The next password after abcdefgh is abcdffaa.") {
                assertEquals("abcdffaa", day11.part1(TextFromString("abcdefgh")))
            }
            it("The next password after ghijklmn is ghjaabcc.") {
                assertEquals("ghjaabcc", day11.part1(TextFromString("ghijklmn")))
            }
            it("should answer What should his next password be?") {
                assertEquals("hxbxxyzz", day11.part1(TextFromString("hxbxwxba")))
            }
        }
        context("part 2") {
            it("should answer Santa's password expired again. What's the next one?") {
                assertEquals("hxcaabcc", day11.part2(TextFromString("hxbxwxba")))
            }
        }
    }
})
