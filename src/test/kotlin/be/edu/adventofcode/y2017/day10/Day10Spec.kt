package be.edu.adventofcode.y2017.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day10Spec : Spek({
    given("day 10") {
        val day10 = Day10()
        on("part 1") {
            it("The first two numbers in the list end up being 3 and 4; to check the process, you can multiply them together to produce 12.") {
                assertEquals(12, day10.part1(TextFromString("3, 4, 1, 5"), 5))
            }
            it("should answer What is the result of multiplying the first two numbers in the list?") {
                assertEquals(0, day10.part1(DayInput().text(day10), 256))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day10.part2(TextFromString("line"), 5))
            }
            it("should answer Part2") {
                assertEquals(0, day10.part2(DayInput().text(day10), 256))
            }
        }
    }
})
