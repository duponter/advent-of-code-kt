package be.edu.adventofcode.y2017.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day07Spec : Spek({
    given("day 07") {
        val day07 = Day07()
        on("part 1") {
            it("tknk is at the bottom of the tower (the bottom program)") {
                assertEquals("tknk", day07.part1(LinesFromArray("pbga (66)",
                        "xhth (57)",
                        "ebii (61)",
                        "havc (66)",
                        "ktlj (57)",
                        "fwft (72) -> ktlj, cntj, xhth",
                        "qoyq (66)",
                        "padx (45) -> pbga, havc, qoyq",
                        "tknk (41) -> ugml, padx, fwft",
                        "jptl (61)",
                        "ugml (68) -> gyxo, ebii, jptl",
                        "gyxo (61)",
                        "cntj (57)")))
            }
            it("should answer  What is the name of the bottom program?") {
                assertEquals("qibuqqg", day07.part1(DayInput().lines(day07)))
            }
        }
        on("part 2") {
            it("testcase") {
                assertEquals(1, day07.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day07.part2(DayInput().lines(day07)))
            }
        }
    }
})
