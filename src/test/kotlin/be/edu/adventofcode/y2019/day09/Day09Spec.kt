package be.edu.adventofcode.y2019.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day09Spec : Spek({
    describe("day 09") {
        val day09 = Day09()
        context("part 1") {
            it("testcase") {
                println("copy: ${day09.part1(TextFromString("109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99"))}")
                println("16-digits: ${day09.part1(TextFromString("1102,34915192,34915192,7,4,7,99,0"))}")
                assertEquals(1125899906842624, day09.part1(TextFromString("104,1125899906842624,99")))
            }
            it("What BOOST keycode does it produce?") {
                assertEquals(0, day09.part1(DayInput().text(day09)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day09.part2(TextFromString("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day09.part2(DayInput().text(day09)))
            }
        }
    }
})
