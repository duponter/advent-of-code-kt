package be.edu.adventofcode.y2020

import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day15Spec : DescribeSpec({
    xdescribe("day 15") {
        val day15 = Day15()
        context("part 1") {
            it("Part 1 - Testcase 1 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("0,3,6")) shouldBe 436
            }
            it("Part 1 - Testcase 2 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("1,3,2")) shouldBe 1
            }
            it("Part 1 - Testcase 3 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("2,1,3")) shouldBe 10
            }
            it("Part 1 - Testcase 4 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("1,2,3")) shouldBe 27
            }
            it("Part 1 - Testcase 5 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("2,3,1")) shouldBe 78
            }
            it("Part 1 - Testcase 6 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("3,2,1")) shouldBe 438
            }
            it("Part 1 - Testcase 7 - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("3,1,2")) shouldBe 1836
            }
            it("Part 1 - Solution - What will be the 2020th number spoken?") {
                day15.part1(TextFromString("0,1,5,10,3,12,19")) shouldBe 1373
            }
        }
        context("part 2") {
            it("Part 2 - Testcase 1 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("0,3,6")) shouldBe 175594
            }
            it("Part 2 - Testcase 2 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("1,3,2")) shouldBe 2578
            }
            it("Part 2 - Testcase 3 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("2,1,3")) shouldBe 3544142
            }
            it("Part 2 - Testcase 4 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("1,2,3")) shouldBe 261214
            }
            it("Part 2 - Testcase 5 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("2,3,1")) shouldBe 6895259
            }
            it("Part 2 - Testcase 6 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("3,2,1")) shouldBe 18
            }
            it("Part 2 - Testcase 7 - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("3,1,2")) shouldBe 362
            }
            it("Part 2 - Solution - What will be the 30000000th number spoken?") {
                day15.part2(TextFromString("0,1,5,10,3,12,19")) shouldBe 0
            }
        }
    }
})
