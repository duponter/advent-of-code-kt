package be.edu.adventofcode.y2021.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day12Spec : Spek({
    describe("day 12") {
        val day12 = Day12()
        val testInput1 = LinesFromArray(
            "start-A",
            "start-b",
            "A-c",
            "A-b",
            "b-d",
            "A-end",
            "b-end"
        )
        val testInput2 = LinesFromArray(
            "dc-end",
            "HN-start",
            "start-kj",
            "dc-start",
            "dc-HN",
            "LN-dc",
            "HN-end",
            "kj-sa",
            "kj-HN",
            "kj-dc"
        )
        val testInput3 = LinesFromArray(
            "fs-end",
            "he-DX",
            "fs-he",
            "start-DX",
            "pj-DX",
            "end-zg",
            "zg-sl",
            "zg-pj",
            "pj-he",
            "RW-he",
            "fs-DX",
            "pj-RW",
            "zg-RW",
            "start-pj",
            "he-WI",
            "zg-he",
            "pj-fs",
            "start-RW"
        )
        context("part 1") {
            it("Part 1 - Testcase - How many paths through this cave system are there that visit small caves at most once?") {
                assertEquals(10, day12.part1(testInput1))
                assertEquals(19, day12.part1(testInput2))
                assertEquals(226, day12.part1(testInput3))
            }
            xit("Part 1 - Solution - How many paths through this cave system are there that visit small caves at most once?") {
                assertEquals(0, day12.part1(DayInput().lines(day12)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day12.part2(testInput1))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day12.part2(DayInput().lines(day12)))
            }
        }
    }
})
