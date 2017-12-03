package be.edu.adventofcode.y2017.day02

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day02Spec : Spek({
    given("day 02") {
        val day02 = Day02()
        on("part 1") {
            it("the spreadsheet's checksum would be 8 + 4 + 6 = 18") {
                assertEquals(18, day02.part1(LinesFromArray("5 1 9 5", "7 5 3", "2 4 6 8")))
            }
            it("should answer What is the checksum for the spreadsheet in your puzzle input?") {
                assertEquals(0, day02.part1(DayInput().lines(day02)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day02.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day02.part2(DayInput().lines(day02)))
            }
        }
    }
})
