package be.edu.adventofcode.y2019.day06

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day06Spec : DescribeSpec({
    describe("day 06") {
        val day06 = Day06()
        context("part 1") {
            it("testcase") {
                day06.part1(LinesFromArray("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L")) shouldBe 42
            }
            it("What is the total number of direct and indirect orbits in your map data?") {
                day06.part1(DayInput().lines(day06)) shouldNotBe 1709
                day06.part1(DayInput().lines(day06)) shouldBe 106065
            }
        }
        context("part 2") {
            it("testcase") {
                day06.part2(LinesFromArray("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN")) shouldBe 4
            }
            it("What is the minimum number of orbital transfers required?") {
                day06.part2(DayInput().lines(day06)) shouldBe 253
            }
        }
    }
})
