package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day12Spec : DescribeSpec({
    describe("day 12") {
        val day12 = Day12()
        val testInput = LinesFromArray(
            "Sabqponm",
            "abcryxxl",
            "accszExk",
            "acctuvwj",
            "abdefghi"
        )
        xcontext("part 1") {
            it("Part 1 - Testcase - What is the fewest steps required to move from your current position to the location that should get the best signal?") {
                day12.part1(testInput) shouldBe 31
            }
            it("Part 1 - Solution - What is the fewest steps required to move from your current position to the location that should get the best signal?") {
                day12.part1(DayInput().lines(day12)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day12.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day12.part2(DayInput().lines(day12)) shouldBe 0
            }
        }
    }
})
