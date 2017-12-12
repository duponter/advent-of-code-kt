package be.edu.adventofcode.y2017.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertTrue

object Day12Spec : Spek({
    given("day 12") {
        val day12 = Day12()
        on("part 1") {
            it("a total of 6 programs are in this group; all but program 1") {
                assertEquals(6, day12.part1(LinesFromArray("0 <-> 2",
                        "1 <-> 1",
                        "2 <-> 0, 3, 4",
                        "3 <-> 2, 4",
                        "4 <-> 2, 3, 6",
                        "5 <-> 6",
                        "6 <-> 4, 5")))
            }
            it("should answer How many programs are in the group that contains program ID 0?") {
                assertEquals(145, day12.part1(DayInput().lines(day12)))
            }
        }
        on("part 2") {
            it("should answer How many groups are there in total?") {
                assertTrue { day12.part2(DayInput().lines(day12)) < 208 }
                assertEquals(0, day12.part2(DayInput().lines(day12)))
            }
        }
    }
})
