package be.edu.adventofcode.y2015.day04

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            xit("If your secret key is abcdef, the lowest positive number is 609043") {
                day04.part1(TextFromString("abcdef")) shouldBe 609043
            }
            xit("If your secret key is pqrstuv, the lowest positive number is 1048970") {
                day04.part1(TextFromString("pqrstuv")) shouldBe 1048970
            }
            xit("should answer What is the lowest positive number that produces a hash starting with 5+ leading zeros?") {
                day04.part1(TextFromString("bgvyzdsv")) shouldBe 254575
            }
        }
        context("part 2") {
            xit("should answer What is the lowest positive number that produces a hash starting with 6+ leading zeros?") {
                day04.part2(TextFromString("bgvyzdsv")) shouldBe 1038736
            }
        }
    }
})
