package be.edu.adventofcode.y2017.day19

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day19Spec : Spek({
    given("day 19") {
        val day19 = Day19()
        on("part 1") {
            it("Following the path to the end, the letters it sees on its path are ABCDEF.") {
                assertEquals("ABCDEF", day19.part1(LinesFromArray("     |         ",
                        "     |  +--+   ",
                        "     A  |  C   ",
                        " F---|----E|--+",
                        "     |  |  |  D",
                        "     +B-+  +--+")))
            }
            it("should answer What letters will it see (in the order it would see them) if it follows the path?") {
                assertEquals("", day19.part1(DayInput().lines(day19)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day19.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day19.part2(DayInput().lines(day19)))
            }
        }
    }
})
