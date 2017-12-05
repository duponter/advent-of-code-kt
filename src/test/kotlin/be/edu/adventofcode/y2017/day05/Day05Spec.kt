package be.edu.adventofcode.y2017.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day05Spec : Spek({
    given("day 05") {
        val day05 = Day05()
        on("part 1") {
            it("the exit is reached in 5 steps.") {
                assertEquals(5, day05.part1(LinesFromArray("0", "3", "0", "1", "-3")))
            }
            it("should answer How many steps does it take to reach the exit?") {
                assertEquals(388611, day05.part1(DayInput().lines(day05)))
            }
        }
        on("part 2") {
            it("Using this rule with the above example, the process now takes 10 steps") {
                assertEquals(10, day05.part2(LinesFromArray("0", "3", "0", "1", "-3")))
            }
            it("should answer How many steps does it now take to reach the exit?") {
                assertEquals(0, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
