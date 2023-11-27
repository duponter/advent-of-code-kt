package be.edu.adventofcode.y2017.day15

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day15Spec : DescribeSpec({
    describe("day 15") {
        val day15 = Day15()
        context("part 1") {
            it("After processing these five pairs, the judge would have added only 1 to its total.") {
                day15.part1(Pair(65, 8921), 5) shouldBe 1
            }
            it("The judge would eventually find a total of 588 pairs that match in their lowest 16 bits") {
                day15.part1(Pair(65, 8921), 40000000) shouldBe 588
            }
            it("should answer After 40 million pairs, what is the judge's final count?") {
                day15.part1(Pair(634, 301), 40000000) shouldBe 573
            }
        }
        context("part 2") {
            it("After five million pairs, the judge would eventually find a total of 309 pairs that match in their lowest 16 bits.") {
                day15.part2(Pair(65, 8921), 5000000) shouldBe 309
            }
            it("should answer After 5 million pairs, but using this new generator logic, what is the judge's final count?") {
                day15.part2(Pair(634, 301), 5000000) shouldBe 294
            }
        }
    }
})
