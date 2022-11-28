package be.edu.adventofcode.y2017.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("{}, score of 1.") {
                day09.part1(TextFromString("{}")) shouldBe 1
            }
            it("{{{}}}, score of 1 + 2 + 3 = 6.") {
                day09.part1(TextFromString("{{{}}}")) shouldBe 6
            }
            it("{{},{}}, score of 1 + 2 + 2 = 5.") {
                day09.part1(TextFromString("{{},{}}")) shouldBe 5
            }
            it("{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.") {
                day09.part1(TextFromString("{{{},{},{{}}}}")) shouldBe 16
            }
            it("{<a>,<a>,<a>,<a>}, score of 1.") {
                day09.part1(TextFromString("{<a>,<a>,<a>,<a>}")) shouldBe 1
            }
            it("{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.") {
                day09.part1(TextFromString("{{<ab>},{<ab>},{<ab>},{<ab>}}")) shouldBe 9
            }
            it("{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.") {
                day09.part1(TextFromString("{{<!!>},{<!!>},{<!!>},{<!!>}}")) shouldBe 9
            }
            it("{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3") {
                day09.part1(TextFromString("{{<a!>},{<a!>},{<a!>},{<ab>}}")) shouldBe 3
            }
            it("should answer What is the total score for all groups in your input?") {
                day09.part1(DayInput().text(day09)) shouldBe 20530
            }
        }
        context("part 2") {
            it("<>, 0 characters.") {
                day09.part2(TextFromString("<>")) shouldBe 0
            }
            it("<random characters>, 17 characters.") {
                day09.part2(TextFromString("<random characters>")) shouldBe 17
            }
            it("<<<<>, 3 characters.") {
                day09.part2(TextFromString("<<<<>")) shouldBe 3
            }
            it("<{!>}>, 2 characters.") {
                day09.part2(TextFromString("<{!>}>")) shouldBe 2
            }
            it("<!!>, 0 characters.") {
                day09.part2(TextFromString("<!!>")) shouldBe 0
            }
            it("<!!!>>, 0 characters.") {
                day09.part2(TextFromString("<!!!>>")) shouldBe 0
            }
            it("<{o\"i!a,<{i<a>, 10 characters.") {
                day09.part2(TextFromString("<{o\"i!a,<{i<a>")) shouldBe 10
            }
            it("should answer How many non-canceled characters are within the garbage in your puzzle input?") {
                day09.part2(DayInput().text(day09)) shouldBe 9978
            }
        }
    }
})
