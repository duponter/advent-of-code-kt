package be.edu.adventofcode.y2019.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("testcase") {
                assertEquals(159, day03.part1(LinesFromArray("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")))
                assertEquals(135, day03.part1(LinesFromArray("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")))
            }
            it("What is the Manhattan distance from the central port to the closest intersection?") {
                assertEquals(280, day03.part1(DayInput().lines(day03)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(30, day03.part2(LinesFromArray("R8,U5,L5,D3", "U7,R6,D4,L4")))
                assertEquals(610, day03.part2(LinesFromArray("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")))
                assertEquals(410, day03.part2(LinesFromArray("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")))
            }
            it("What is the fewest combined steps the wires must take to reach an intersection?") {
                assertEquals(10554, day03.part2(DayInput().lines(day03)))
            }
        }
    }
})
