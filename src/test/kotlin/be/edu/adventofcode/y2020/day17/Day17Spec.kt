package be.edu.adventofcode.y2020.day17

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.xdescribe
import kotlin.test.assertEquals

object Day17Spec : Spek({
    xdescribe("day 17") {
        val day17 = Day17()
        context("part 1") {
            it("Part 1 - Testcase - How many cubes are left in the active state after the sixth cycle?") {
                assertEquals(112, day17.part1(LinesFromArray(".#.", "..#", "###")))
            }
            it("Part 1 - Solution - How many cubes are left in the active state after the sixth cycle?") {
                assertEquals(0, day17.part1(DayInput().lines(day17)))
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                assertEquals(1, day17.part2(LinesFromArray("line")))
            }
            it("Part 2 - Solution - ") {
                assertEquals(0, day17.part2(DayInput().lines(day17)))
            }
        }
    }
})
