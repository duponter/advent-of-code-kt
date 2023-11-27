package be.edu.adventofcode.y2017.day03

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("Data from square 1 is carried 0 steps, since it's at the access port.") {
                day03.part1(1) shouldBe 0
            }
            it("Data from square 12 is carried 3 steps, such as: down, left, left.") {
                day03.part1(12) shouldBe 3
            }
            it("Data from square 23 is carried only 2 steps: up twice.") {
                day03.part1(23) shouldBe 2
            }
            it("Data from square 1024 must be carried 31 steps.") {
                day03.part1(1024) shouldBe 31
            }
            xit("should answer How many steps are required to carry the data from the square identified in your puzzle input all the way to the access port?") {
                day03.part1(312051) shouldBe 430
            }
        }
        context("part 2") {
            it("Square 1 starts with the value 1.") {
                day03.part2(1) shouldBe 2
            }
            it("Square 2 has only one adjacent filled square (with value 1), so it also stores 1.") {
                day03.part2(2) shouldBe 4
            }
            it("Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.") {
                day03.part2(3) shouldBe 4
            }
            it("Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.") {
                day03.part2(4) shouldBe 5
            }
            it("Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.") {
                day03.part2(5) shouldBe 10
            }
            it("should answer What is the first value written that is larger than your puzzle input?") {
                day03.part2(312051) shouldBe 312453
            }
        }
    }
})
