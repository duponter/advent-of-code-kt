package be.edu.adventofcode.y2017.day19

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day19Spec : DescribeSpec({
    describe("day 19") {
        val day19 = Day19()
        context("part 1") {
            it("Following the path to the end, the letters it sees on its path are ABCDEF.") {
                day19.part1(
                    LinesFromArray(
                        "     |         ",
                        "     |  +--+   ",
                        "     A  |  C   ",
                        " F---|----E|--+",
                        "     |  |  |  D",
                        "     +B-+  +--+"
                    )
                ) shouldBe "ABCDEF"
            }
            it("should answer What letters will it see (in the order it would see them) if it follows the path?") {
                day19.part1(DayInput().lines(day19)) shouldBe "RUEDAHWKSM"
            }
        }
        context("part 2") {
            it("This would result in a total of 38 steps.") {
                day19.part2(
                    LinesFromArray(
                        "     |         ",
                        "     |  +--+   ",
                        "     A  |  C   ",
                        " F---|----E|--+",
                        "     |  |  |  D",
                        "     +B-+  +--+"
                    )
                ) shouldBe 38
            }
            it("should answer How many steps does the packet need to go?") {
                day19.part2(DayInput().lines(day19)) shouldBe 17264
            }
        }
    }
})
