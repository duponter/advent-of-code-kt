package be.edu.adventofcode.y2015.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("turn on 0,0 through 999,999 would turn on (or leave on) every light") {
                day06.part1(LinesFromArray("turn on 0,0 through 999,999")) shouldBe 1000000
            }
            it("toggle 0,0 through 999,0 would toggle the first line of 1000 lights") {
                day06.part1(LinesFromArray("toggle 0,0 through 999,0")) shouldBe 1000
            }
            it("turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights") {
                day06.part1(LinesFromArray("turn on 0,0 through 999,999", "turn off 499,499 through 500,500")) shouldBe 999996
            }
            it("should answer How many lights are lit?") {
                day06.part1(DayInput().lines(day06)) shouldBe 400410
            }
        }
        context("part 2") {
            it("turn on 0,0 through 0,0 would increase the total brightness by 1") {
                day06.part2(LinesFromArray("turn on 0,0 through 0,0")) shouldBe 1
            }
            it("toggle 0,0 through 999,999 would increase the total brightness by 2000000") {
                day06.part2(LinesFromArray("toggle 0,0 through 999,999")) shouldBe 2000000
            }
            it("should answer What is the total brightness of all lights combined?") {
                day06.part2(DayInput().lines(day06)) shouldBe 15343601
            }
        }
    }
})
