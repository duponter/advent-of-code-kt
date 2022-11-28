package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.DayInput
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        context("part 1") {
            it("On the layer with the fewest 0 digits, what is the number of 1 digits multiplied by the number of 2 digits?") {
                assertEquals(2032, day08.part1(DayInput().text(day08)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals("0110", Image(2, 2).flatten("0222112222120000".map { it.toString().toInt() }).content())
            }
            it("What message is produced after decoding your image?") {
                assertEquals(150, day08.part2(DayInput().text(day08)))
            }
        }
    }
})
