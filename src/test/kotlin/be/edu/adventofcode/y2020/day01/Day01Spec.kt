package be.edu.adventofcode.y2020.day01

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day01Spec : Spek({
    describe("day 01") {
        val day01 = Day01()
        context("part 1") {
            it("Multiplying two entries that sum to 2020 (1721 and 299) = 514579") {
                assertEquals(514579, day01.part1(LinesFromArray("1721", "979", "366", "299", "675", "1456")))
            }
            it("should answer Part1") {
                assertEquals(633216, day01.part1(DayInput().lines(day01)))
            }
        }
        context("part 2") {
            it("Multiplying three entries that sum to 2020 (979, 366, and 675) = 241861950") {
                assertEquals(241861950, day01.part2(LinesFromArray("1721", "979", "366", "299", "675", "1456")))
            }
            it("should answer Part2") {
                assertEquals(68348924, day01.part2(DayInput().lines(day01)))
            }
        }
    }
})
