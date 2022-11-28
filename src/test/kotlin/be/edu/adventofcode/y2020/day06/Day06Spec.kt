package be.edu.adventofcode.y2020.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("Answered questions") {
                assertEquals(11, day06.part1(TextFromString("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb")))
            }
            it("Part 1 - What is the sum of those counts?") {
                assertEquals(6532, day06.part1(DayInput().text(day06)))
            }
        }
        context("part 2") {
            it("Same questions answered") {
                assertEquals(6, day06.part2(TextFromString("abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb")))
            }
            it("Part 2 - What is the sum of those counts?") {
                assertEquals(3427, day06.part2(DayInput().text(day06)))
            }
        }
    }
})
