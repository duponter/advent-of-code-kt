package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
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
        context("part 2") {
            it("Part 2 - Testcase - How many characters need to be processed before the first start-of-message marker is detected?") {
                day06.part2(TextFromString("mjqjpqmgbljsphdztnvjfqwrcgsmlb")) shouldBe 19
                day06.part2(TextFromString("bvwbjplbgvbhsrlpgdmjqwftvncz")) shouldBe 23
                day06.part2(TextFromString("nppdvjthqldpwncqszvftbrmjlhg")) shouldBe 23
                day06.part2(TextFromString("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")) shouldBe 29
                day06.part2(TextFromString("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")) shouldBe 26
            }
            it("Part 2 - Solution - How many characters need to be processed before the first start-of-message marker is detected?") {
                day06.part2(DayInput().text(day06)) shouldBe 2950
            }
        }
    }
})
