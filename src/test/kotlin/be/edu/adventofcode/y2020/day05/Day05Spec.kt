package be.edu.adventofcode.y2020.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day05Spec : DescribeSpec({
    describe("day 05") {
        val day05 = Day05()
        context("part 1") {
            it("seat IDs for boarding passes") {
                day05.part1(LinesFromArray("FBFBBFFRLR")) shouldBe 357
                day05.part1(LinesFromArray("BFFFBBFRRR")) shouldBe 567
                day05.part1(LinesFromArray("FFFBBBFRRR")) shouldBe 119
                day05.part1(LinesFromArray("BBFFBBFRLL")) shouldBe 820
            }
            it("Part 1 - What is the highest seat ID on a boarding pass?") {
                day05.part1(DayInput().lines(day05)) shouldBe 878
            }
        }
        context("part 2") {
            it("Part 2 - What is the ID of your seat?") {
                day05.part2(DayInput().lines(day05)) shouldNotBe 55
                day05.part2(DayInput().lines(day05)) shouldBe 504
            }
        }
    }
})
