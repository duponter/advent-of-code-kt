package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.DayInput
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("On the layer with the fewest 0 digits, what is the number of 1 digits multiplied by the number of 2 digits?") {
                day08.part1(DayInput().text(day08)) shouldBe 2032
            }
        }
        context("part 2") {
            it("testcase") {
                Image(2, 2).flatten("0222112222120000".map { it.toString().toInt() }).content() shouldBe "0110"
            }
            it("What message is produced after decoding your image?") {
                day08.part2(DayInput().text(day08)) shouldBe 150
            }
        }
    }
})
