package be.edu.adventofcode.y2015.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("The shortest of these is London -> Dublin -> Belfast = 605") {
                day09.part1(
                    LinesFromArray(
                        "London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141"
                    )
                ) shouldBe 605
            }
            it("should answer What is the distance of the shortest route?") {
                day09.part1(DayInput().lines(day09)) shouldBe 141
            }
        }
        context("part 2") {
            it("The longest of these is Dublin -> London -> Belfast = 982") {
                day09.part2(
                    LinesFromArray(
                        "London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141"
                    )
                ) shouldBe 982
            }
            it("should answer What is the distance of the longest route?") {
                day09.part2(DayInput().lines(day09)) shouldBe 736
            }
        }
    }
})
