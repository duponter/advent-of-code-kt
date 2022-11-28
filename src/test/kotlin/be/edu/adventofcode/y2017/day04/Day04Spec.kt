package be.edu.adventofcode.y2017.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("aa bb cc dd ee is valid.") {
                day04.part1(LinesFromArray("aa bb cc dd ee")) shouldBe 1
            }
            it("aa bb cc dd aa is not valid - the word aa appears more than once.") {
                day04.part1(LinesFromArray("aa bb cc dd aa")) shouldBe 0
            }
            it("aa bb cc dd aaa is valid - aa and aaa count as different words.") {
                day04.part1(LinesFromArray("aa bb cc dd aaa")) shouldBe 1
            }
            it("should answer How many passphrases are valid?") {
                day04.part1(DayInput().lines(day04)) shouldBe 477
            }
        }
        context("part 2") {
            it("abcde fghij is a valid passphrase.") {
                day04.part2(LinesFromArray("abcde fghij")) shouldBe 1
            }
            it("abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.") {
                day04.part2(LinesFromArray("abcde xyz ecdab")) shouldBe 0
            }
            it("a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.") {
                day04.part2(LinesFromArray("a ab abc abd abf abj")) shouldBe 1
            }
            it("iiii oiii ooii oooi oooo is valid.") {
                day04.part2(LinesFromArray("iiii oiii ooii oooi oooo")) shouldBe 1
            }
            it("oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.") {
                day04.part2(LinesFromArray("oiii ioii iioi iiio")) shouldBe 0
            }
            it("should answer Under this new system policy, how many passphrases are valid?") {
                day04.part2(DayInput().lines(day04)) shouldBe 167
            }
        }
    }
})
