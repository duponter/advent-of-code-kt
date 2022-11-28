package be.edu.adventofcode.y2021.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("Part 1 - Testcase - How many lanternfish would there be after 80 days?") {
                assertEquals(26, day06.part1(TextFromString("3,4,3,1,2"), 18))
                assertEquals(5934, day06.part1(TextFromString("3,4,3,1,2")))
            }
            it("Part 1 - Solution - How many lanternfish would there be after 80 days?") {
                assertEquals(365862, day06.part1(DayInput().text(day06)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - How many lanternfish would there be after 256 days?") {
                assertEquals(26984457539, day06.part2(TextFromString("3,4,3,1,2")))
            }
            it("Part 2 - Solution - How many lanternfish would there be after 256 days?") {
                assertEquals(1653250886439, day06.part2(DayInput().text(day06)))
            }
        }
    }
})
