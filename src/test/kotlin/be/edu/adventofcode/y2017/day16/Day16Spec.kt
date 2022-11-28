package be.edu.adventofcode.y2017.day16

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day16Spec : DescribeSpec({
    describe("day 16") {
        val day16 = Day16()
        context("part 1") {
            it("After finishing their dance, the programs end up in order baedc.") {
                day16.part1("abcde", TextFromString("s1,x3/4,pe/b")) shouldBe "baedc"
            }
            it("should answer In what order are the programs standing after their dance?") {
                day16.part1(CharRange('a', 'p').joinToString(""), DayInput().text(day16)) shouldBe "glnacbhedpfjkiom"
            }
        }
        xcontext("part 2") {
            it("should answer In what order are the programs standing after their billion dances?") {
                val part2 = day16.part2(DayInput().text(day16))
                part2 shouldNotBe "gbnacfhedjklmiop"
                part2 shouldNotBe "afcdekghilmbpnoj"
                part2 shouldBe ""
            }
        }
    }
})
