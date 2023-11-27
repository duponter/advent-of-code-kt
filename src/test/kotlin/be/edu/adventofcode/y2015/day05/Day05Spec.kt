package be.edu.adventofcode.y2015.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("ugknbfddgicrmopn is nice") {
                day05.part1(LinesFromArray("ugknbfddgicrmopn")) shouldBe 1
            }
            it("aaa is nice") {
                day05.part1(LinesFromArray("aaa")) shouldBe 1
            }
            it("jchzalrnumimnmhp is naughty") {
                day05.part1(LinesFromArray("jchzalrnumimnmhp")) shouldBe 0
            }
            it("haegwjzuvuyypxyu is naughty") {
                day05.part1(LinesFromArray("haegwjzuvuyypxyu")) shouldBe 0
            }
            it("dvszwmarrgswjxmb is naughty") {
                day05.part1(LinesFromArray("dvszwmarrgswjxmb")) shouldBe 0
            }
            it("should answer How many strings are nice?") {
                day05.part1(DayInput().lines(day05)) shouldBe 236
            }
        }
        context("part 2") {
            it("qjhvhtzxzqqjkmpb is nice") {
                day05.part2(LinesFromArray("qjhvhtzxzqqjkmpb")) shouldBe 1
            }
            it("xxyxx is nice") {
                day05.part2(LinesFromArray("xxyxx")) shouldBe 1
            }
            it("uurcxstgmygtbstg is naughty") {
                day05.part2(LinesFromArray("uurcxstgmygtbstg")) shouldBe 0
            }
            it("ieodomkazucvgmuy is naughty") {
                day05.part2(LinesFromArray("ieodomkazucvgmuy")) shouldBe 0
            }
            it("should answer How many strings are nice under these new rules?") {
                day05.part2(DayInput().lines(day05)) shouldBe 51
            }
        }
    }
})
