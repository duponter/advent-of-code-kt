package be.edu.adventofcode.y2020.day17

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day17Spec : DescribeSpec({
    xdescribe("day 17") {
        val day17 = Day17()
        context("part 1") {
            it("Part 1 - Testcase - How many cubes are left in the active state after the sixth cycle?") {
                day17.part1(LinesFromArray(".#.", "..#", "###")) shouldBe 112
            }
            it("Part 1 - Solution - How many cubes are left in the active state after the sixth cycle?") {
                day17.part1(DayInput().lines(day17)) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day17.part2(LinesFromArray("line")) shouldBe 1
            }
            it("Part 2 - Solution - ") {
                day17.part2(DayInput().lines(day17)) shouldBe 0
            }
        }
    }
})
