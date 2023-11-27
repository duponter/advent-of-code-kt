package be.edu.adventofcode.y2015.day02

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day02Spec : DescribeSpec({
    describe("examples day 02 part 1") {
        Present(2, 3, 4).surfaceArea() shouldBe 52
        Present(2, 3, 4).smallestSideArea() shouldBe 6
        Present(1, 1, 10).surfaceArea() shouldBe 42
        Present(1, 1, 10).smallestSideArea() shouldBe 1
    }
    describe("examples day 02 part 2") {
        Present(2, 3, 4).shortestDistance() shouldBe 10
        Present(2, 3, 4).volume() shouldBe 24
        Present(1, 1, 10).shortestDistance() shouldBe 4
        Present(1, 1, 10).volume() shouldBe 10
    }
    describe("day 02") {
        val day02 = Day02()
        context("part 1") {
            val squareFeet = day02.part1()
            it("should answer How many total square feet of wrapping paper should they order?") {
                squareFeet shouldBe 1586300
            }
        }
        context("part 2") {
            val position = day02.part2()
            it("should answer How many total feet of ribbon should they order?") {
                position shouldBe 3737498
            }
        }
    }
})
