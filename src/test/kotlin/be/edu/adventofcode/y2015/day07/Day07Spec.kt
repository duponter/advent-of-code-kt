package be.edu.adventofcode.y2015.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day07Spec : Spek({
    given("day 07") {
        val day07 = Day07();
        on("part 1") {
            it("signals on the wires of a simple circuit") {
                val map = day07.parseLines(LinesFromArray(
                        "123 -> x",
                        "456 -> y",
                        "x AND y -> d",
                        "x OR y -> e",
                        "x LSHIFT 2 -> f",
                        "y RSHIFT 2 -> g",
                        "NOT x -> h",
                        "NOT y -> i"
                ))
                assertEquals(72, map["d"]!!.connect { map[it]!! })
                assertEquals(507, map["e"]!!.connect { map[it]!! })
                assertEquals(492, map["f"]!!.connect { map[it]!! })
                assertEquals(114, map["g"]!!.connect { map[it]!! })
                assertEquals(65412, map["h"]!!.connect { map[it]!! })
                assertEquals(65079, map["i"]!!.connect { map[it]!! })
                assertEquals(456, map["y"]!!.connect { map[it]!! })
                assertEquals(123, map["x"]!!.connect { map[it]!! })

            }
            it("should answer What signal is ultimately provided to wire a?") {
                assertEquals(46065, day07.part1(DayInput().lines(day07)))
            }
        }
        on("part 2") {
            it("should answer What new signal is ultimately provided to wire a?") {
                assertEquals(14134, day07.part2(DayInput().lines(day07)))
            }
        }
    }
})
