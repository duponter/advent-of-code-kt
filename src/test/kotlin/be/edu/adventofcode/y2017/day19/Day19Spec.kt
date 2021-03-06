package be.edu.adventofcode.y2017.day19

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day19Spec : Spek({
    describe("day 19") {
        val day19 = Day19()
        context("part 1") {
            it("Following the path to the end, the letters it sees on its path are ABCDEF.") {
                assertEquals("ABCDEF", day19.part1(LinesFromArray("     |         ",
                        "     |  +--+   ",
                        "     A  |  C   ",
                        " F---|----E|--+",
                        "     |  |  |  D",
                        "     +B-+  +--+")))
            }
            it("should answer What letters will it see (in the order it would see them) if it follows the path?") {
                assertEquals("RUEDAHWKSM", day19.part1(DayInput().lines(day19)))
            }
        }
        context("part 2") {
            it("This would result in a total of 38 steps.") {
                assertEquals(38, day19.part2(LinesFromArray("     |         ",
                        "     |  +--+   ",
                        "     A  |  C   ",
                        " F---|----E|--+",
                        "     |  |  |  D",
                        "     +B-+  +--+")))
            }
            it("should answer How many steps does the packet need to go?") {
                assertEquals(17264, day19.part2(DayInput().lines(day19)))
            }
        }
    }
})
