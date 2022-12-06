package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        val testInput = LinesFromArray(
            ""
        )
        context("part 1") {
            it("Part 1 - Testcase - How many characters need to be processed before the first start-of-packet marker is detected?") {
                day06.part1(TextFromString("mjqjpqmgbljsphdztnvjfqwrcgsmlb")) shouldBe 7
                day06.part1(TextFromString("bvwbjplbgvbhsrlpgdmjqwftvncz")) shouldBe 5
                day06.part1(TextFromString("nppdvjthqldpwncqszvftbrmjlhg")) shouldBe 6
                day06.part1(TextFromString("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")) shouldBe 10
                day06.part1(TextFromString("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")) shouldBe 11
            }
            it("Part 1 - Solution - How many characters need to be processed before the first start-of-packet marker is detected?") {
                day06.part1(DayInput().text(day06)) shouldBe 1757
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day06.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day06.part2(DayInput().lines(day06)) shouldBe 0
            }
        }
    }
})
