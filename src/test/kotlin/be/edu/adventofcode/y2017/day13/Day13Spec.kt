package be.edu.adventofcode.y2017.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day13Spec : DescribeSpec({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("The trip severity is 0*3 + 6*4 = 24.") {
                day13.part1(
                    LinesFromArray(
                        "0: 3",
                        "1: 2",
                        "4: 4",
                        "6: 4"
                    )
                ) shouldBe 24
            }
            it("should answer What is the severity of your whole trip?") {
                day13.part1(DayInput().lines(day13)) shouldBe 1612
            }
        }
        context("part 2") {
            it("The fewest number of picoseconds you would need to delay to get through safely is 10.") {
                day13.part2(
                    LinesFromArray(
                        "0: 3",
                        "1: 2",
                        "4: 4",
                        "6: 4"
                    )
                ) shouldBe 10
            }
            it("should answer What is the fewest number of picoseconds that you need to delay the packet to pass through the firewall without being caught?") {
                day13.part2(DayInput().lines(day13)) shouldBe 3907994
            }
        }
    }
})
