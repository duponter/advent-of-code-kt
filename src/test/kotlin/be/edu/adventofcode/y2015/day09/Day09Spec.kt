package be.edu.adventofcode.y2015.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day09Spec : Spek({
    given("day 09") {
        val day09 = Day09();
        on("part 1") {
            it("The shortest of these is London -> Dublin -> Belfast = 605") {
                assertEquals(605, day09.part1(LinesFromArray("London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141")))
            }
            it("should answer What is the distance of the shortest route?") {
                assertEquals(141, day09.part1(DayInput().lines(day09)))
            }
        }
        on("part 2") {
            it("The longest of these is Dublin -> London -> Belfast = 982") {
                assertEquals(982, day09.part2(LinesFromArray("London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141")))
            }
            it("should answer What is the distance of the longest route?") {
                assertEquals(736, day09.part2(DayInput().lines(day09)))
            }
        }
    }
})
