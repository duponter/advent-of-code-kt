package be.edu.adventofcode.y2017.day18

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class Day18Spec : DescribeSpec({
    describe("day 18") {
        val day18 = Day18()
        xcontext("part 1") {
            it("At the time the recover operation is executed, the frequency of the last sound played is 4.") {
                day18.part1(
                    LinesFromArray(
                        "set a 1",
                        "add a 2",
                        "mul a a",
                        "mod a 5",
                        "snd a",
                        "set a 0",
                        "rcv a",
                        "jgz a -1",
                        "set a 1",
                        "jgz a -2"
                    )
                ) shouldBe 4
            }
            it("should answer What is the value of the recovered frequency (the value of the most recently played sound) the first time a rcv instruction is executed with a non-zero value?") {
                val part1 = day18.part1(DayInput().lines(day18))
                part1 shouldBeGreaterThan 7481
                part1 shouldBe 0
            }
        }
        xcontext("part 2") {
            it("testcase") {
                day18.part2(LinesFromArray("line")) shouldBe 1
            }
            it("should answer Part2") {
                day18.part2(DayInput().lines(day18)) shouldBe 0
            }
        }
    }
})
