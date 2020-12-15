package be.edu.adventofcode.y2020.day15

import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day15Spec : Spek({
    describe("day 15") {
        val day15 = Day15()
        context("part 1") {
            it("Part 1 - Testcase 1 - What will be the 2020th number spoken?") {
                assertEquals(436, day15.part1(TextFromString("0,3,6")))
            }
            it("Part 1 - Testcase 2 - What will be the 2020th number spoken?") {
                assertEquals(1, day15.part1(TextFromString("1,3,2")))
            }
            it("Part 1 - Testcase 3 - What will be the 2020th number spoken?") {
                assertEquals(10, day15.part1(TextFromString("2,1,3")))
            }
            it("Part 1 - Testcase 4 - What will be the 2020th number spoken?") {
                assertEquals(27, day15.part1(TextFromString("1,2,3")))
            }
            it("Part 1 - Testcase 5 - What will be the 2020th number spoken?") {
                assertEquals(78, day15.part1(TextFromString("2,3,1")))
            }
            it("Part 1 - Testcase 6 - What will be the 2020th number spoken?") {
                assertEquals(438, day15.part1(TextFromString("3,2,1")))
            }
            it("Part 1 - Testcase 7 - What will be the 2020th number spoken?") {
                assertEquals(1836, day15.part1(TextFromString("3,1,2")))
            }
            it("Part 1 - Solution - What will be the 2020th number spoken?") {
                assertEquals(1373, day15.part1(TextFromString("0,1,5,10,3,12,19")))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase 1 - What will be the 30000000th number spoken?") {
                assertEquals(175594, day15.part2(TextFromString("0,3,6")))
            }
            it("Part 2 - Testcase 2 - What will be the 30000000th number spoken?") {
                assertEquals(2578, day15.part2(TextFromString("1,3,2")))
            }
            it("Part 2 - Testcase 3 - What will be the 30000000th number spoken?") {
                assertEquals(3544142, day15.part2(TextFromString("2,1,3")))
            }
            it("Part 2 - Testcase 4 - What will be the 30000000th number spoken?") {
                assertEquals(261214, day15.part2(TextFromString("1,2,3")))
            }
            it("Part 2 - Testcase 5 - What will be the 30000000th number spoken?") {
                assertEquals(6895259, day15.part2(TextFromString("2,3,1")))
            }
            it("Part 2 - Testcase 6 - What will be the 30000000th number spoken?") {
                assertEquals(18, day15.part2(TextFromString("3,2,1")))
            }
            it("Part 2 - Testcase 7 - What will be the 30000000th number spoken?") {
                assertEquals(362, day15.part2(TextFromString("3,1,2")))
            }
            it("Part 2 - Solution - What will be the 30000000th number spoken?") {
                assertEquals(0, day15.part2(TextFromString("0,1,5,10,3,12,19")))
            }
        }
    }
})
