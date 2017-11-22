package be.edu.adventofcode.y2015.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day06Spec : Spek({
    given("day 06") {
        val day06 = Day06();
        on("part 1") {
            it("turn on 0,0 through 999,999 would turn on (or leave on) every light") {
                assertEquals(1000000, day06.part1(LinesFromArray("turn on 0,0 through 999,999")))
            }
            it("toggle 0,0 through 999,0 would toggle the first line of 1000 lights") {
                assertEquals(1000, day06.part1(LinesFromArray("toggle 0,0 through 999,0")))
            }
            it("turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights") {
                assertEquals(999996, day06.part1(LinesFromArray("turn on 0,0 through 999,999", "turn off 499,499 through 500,500")))
            }
            it("should answer How many lights are lit?") {
                assertEquals(400410, day06.part1(DayInput().lines(day06)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day06.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day06.part2(DayInput().lines(day06)))
            }
        }
    }
})
