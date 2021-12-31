package be.edu.adventofcode.y2021.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        val testInput = LinesFromArray(
            "2199943210",
            "3987894921",
            "9856789892",
            "8767896789",
            "9899965678"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of the risk levels of all low points on your heightmap?") {
                assertEquals(15, day09.part1(testInput))
            }
            it("Part 1 - Solution - What is the sum of the risk levels of all low points on your heightmap?") {
                assertEquals(458, day09.part1(DayInput().lines(day09)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What do you get if you multiply together the sizes of the three largest basins?") {
                assertEquals(1134, day09.part2(testInput))
            }
            xit("Part 2 - Solution - What do you get if you multiply together the sizes of the three largest basins?") {
                assertEquals(0, day09.part2(DayInput().lines(day09)), "Result should be higher than 1224300")
            }
            xit("Part 2 - Solution (alternative) - What do you get if you multiply together the sizes of the three largest basins?") {
                assertEquals(0, day09.part2alt(DayInput().lines(day09)), "Result should be higher than 1224300")
            }
        }
    }
})