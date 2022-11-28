package be.edu.adventofcode.y2020.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day10Spec : DescribeSpec({
    xdescribe("day 10") {
        val day10 = Day10()
        context("part 1") {
            it("Part 1 - Testcase 1 - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                day10.part1(LinesFromArray("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")) shouldBe 35
            }
            it("Part 1 - Testcase 2 - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                day10.part1(LinesFromArray("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")) shouldBe 220
            }
            it("Part 1 - Solution - What is the number of 1-jolt differences multiplied by the number of 3-jolt differences?") {
                day10.part1(DayInput().lines(day10)) shouldBe 2470
            }
        }
        context("part 2") {
            it("Part 2 - Testcase 1 - What is the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device?") {
                day10.part2(LinesFromArray("16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4")) shouldBe 8
            }
            xit("Part 2 - Testcase 2 - What is the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device?") {
                day10.part2(LinesFromArray("28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45", "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3")) shouldBe 19208
            }
            xit("Part 2 - Solution - What is the total number of distinct ways you can arrange the adapters to connect the charging outlet to your device?") {
                day10.part2(DayInput().lines(day10)) shouldBe 0
            }
        }
    }
})
