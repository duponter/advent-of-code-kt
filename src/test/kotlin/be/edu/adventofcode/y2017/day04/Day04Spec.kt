package be.edu.adventofcode.y2017.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("aa bb cc dd ee is valid.") {
                assertEquals(1, day04.part1(LinesFromArray("aa bb cc dd ee")))
            }
            it("aa bb cc dd aa is not valid - the word aa appears more than once.") {
                assertEquals(0, day04.part1(LinesFromArray("aa bb cc dd aa")))
            }
            it("aa bb cc dd aaa is valid - aa and aaa count as different words.") {
                assertEquals(1, day04.part1(LinesFromArray("aa bb cc dd aaa")))
            }
            it("should answer How many passphrases are valid?") {
                assertEquals(477, day04.part1(DayInput().lines(day04)))
            }
        }
        context("part 2") {
            it("abcde fghij is a valid passphrase.") {
                assertEquals(1, day04.part2(LinesFromArray("abcde fghij")))
            }
            it("abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.") {
                assertEquals(0, day04.part2(LinesFromArray("abcde xyz ecdab")))
            }
            it("a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.") {
                assertEquals(1, day04.part2(LinesFromArray("a ab abc abd abf abj")))
            }
            it("iiii oiii ooii oooi oooo is valid.") {
                assertEquals(1, day04.part2(LinesFromArray("iiii oiii ooii oooi oooo")))
            }
            it("oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.") {
                assertEquals(0, day04.part2(LinesFromArray("oiii ioii iioi iiio")))
            }
            it("should answer Under this new system policy, how many passphrases are valid?") {
                assertEquals(167, day04.part2(DayInput().lines(day04)))
            }
        }
    }
})
