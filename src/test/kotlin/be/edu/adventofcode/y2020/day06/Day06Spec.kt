package be.edu.adventofcode.y2020.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day06Spec : Spek({
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
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day06.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day06.part2(DayInput().text(day06)))
            }
        }
    }
})
