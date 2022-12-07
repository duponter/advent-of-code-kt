package be.edu.adventofcode.y2021

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            it("Part 1 - Testcase - What do you get if you multiply your final horizontal position by your final depth?") {
                day02.part1(LinesFromArray("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")) shouldBe 150
            }
            it("Part 1 - Solution - What do you get if you multiply your final horizontal position by your final depth?") {
                day02.part1(DayInput().lines(day02)) shouldBe 1840243
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What do you get if you multiply your final horizontal position by your final depth?") {
                day02.part2(LinesFromArray("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")) shouldBe 900
            }
            it("Part 2 - Solution - What do you get if you multiply your final horizontal position by your final depth?") {
                day02.part2(DayInput().lines(day02)) shouldBe 1727785422
            }
        }
    }
})
