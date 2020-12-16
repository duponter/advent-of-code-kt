package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day13Spec : Spek({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("Part 1 - Testcase - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                assertEquals(295, day13.part1(LinesFromArray("939", "7,13,x,x,59,x,31,19")))
            }
            it("Part 1 - Solution - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                assertEquals(2165, day13.part1(DayInput().lines(day13)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(1068781, day13.part2(LinesFromArray("939", "7,13,x,x,59,x,31,19")))
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(3417, day13.part2(LinesFromArray("17,x,13,19")))
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(754018, day13.part2(LinesFromArray("67,7,59,61")))
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(779210, day13.part2(LinesFromArray("67,x,7,59,61")))
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(1261476, day13.part2(LinesFromArray("67,7,x,59,61")))
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(1202161486, day13.part2(LinesFromArray("1789,37,47,1889")))
            }
            xit("Part 2 - Solution - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                assertEquals(0, day13.part2(DayInput().lines(day13), 100000000000000))
            }
        }
    }
})






