package be.edu.adventofcode.y2019.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day09Spec : DescribeSpec({
    xdescribe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("testcase") {
                println("copy: ${day09.part1(TextFromString("109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99"))}")
                println("16-digits: ${day09.part1(TextFromString("1102,34915192,34915192,7,4,7,99,0"))}")
                day09.part1(TextFromString("104,1125899906842624,99")) shouldBe 1125899906842624
            }
            it("What BOOST keycode does it produce?") {
                day09.part1(DayInput().text(day09)) shouldBe 0
            }
        }
        context("part 2") {
            it("testcase") {
                day09.part2(TextFromString("line")) shouldBe 1
            }
            it("should answer Part2") {
                day09.part2(DayInput().text(day09)) shouldBe 0
            }
        }
    }
})
