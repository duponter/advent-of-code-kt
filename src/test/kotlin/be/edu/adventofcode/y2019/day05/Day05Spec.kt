package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("testcase") {
                day05.bothParts(TextFromString("3,0,4,0,99"), 88) shouldBe 88
            }
            it("should answer Part1") {
                day05.bothParts(DayInput().text(day05), 1) shouldBe 15314507
            }
        }
        context("part 2") {
            it("testcase") {
                day05.bothParts(TextFromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"), 6) shouldBe 999
                day05.bothParts(TextFromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"), 7) shouldBe 999
                day05.bothParts(TextFromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"), 8) shouldBe 1000
                day05.bothParts(TextFromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"), 9) shouldBe 1001
                day05.bothParts(TextFromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"), 10) shouldBe 1001
            }
            it("should answer Part2") {
                day05.bothParts(DayInput().text(day05), 5) shouldBe 652726
            }
        }
    }
})
