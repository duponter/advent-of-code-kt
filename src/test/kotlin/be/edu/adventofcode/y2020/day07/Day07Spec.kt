package be.edu.adventofcode.y2020.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day07Spec : Spek({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("Testcase - How many bag colors can eventually contain at least one shiny gold bag?") {
                assertEquals(
                    4, day07.part1(
                        LinesFromArray(
                            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                            "bright white bags contain 1 shiny gold bag.",
                            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                            "faded blue bags contain no other bags.",
                            "dotted black bags contain no other bags.",
                        )
                    )
                )
            }
            xit("Part 1 - How many bag colors can eventually contain at least one shiny gold bag?") {
                assertEquals(0, day07.part1(DayInput().lines(day07)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day07.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day07.part2(DayInput().lines(day07)))
            }
        }
    }
})
