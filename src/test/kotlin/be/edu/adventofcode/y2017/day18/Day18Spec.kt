package be.edu.adventofcode.y2017.day18

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day18Spec : Spek({
    given("day 18") {
        val day18 = Day18()
        on("part 1") {
            it("At the time the recover operation is executed, the frequency of the last sound played is 4.") {
                assertEquals(4, day18.part1(LinesFromArray("set a 1",
                        "add a 2",
                        "mul a a",
                        "mod a 5",
                        "snd a",
                        "set a 0",
                        "rcv a",
                        "jgz a -1",
                        "set a 1",
                        "jgz a -2")))
            }
            it("should answer What is the value of the recovered frequency (the value of the most recently played sound) the first time a rcv instruction is executed with a non-zero value?") {
                assertEquals(0, day18.part1(DayInput().lines(day18)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day18.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day18.part2(DayInput().lines(day18)))
            }
        }
    }
})
