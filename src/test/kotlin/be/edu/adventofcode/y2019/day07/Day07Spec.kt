package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("Max thruster signal from given phase setting sequence") {
                day07.part1(TextFromString("3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0"), listOf(4, 3, 2, 1, 0)) shouldBe 43210
                day07.part1(TextFromString("3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0"), listOf(0, 1, 2, 3, 4)) shouldBe 54321
                day07.part1(TextFromString("3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0"), listOf(1, 0, 4, 3, 2)) shouldBe 65210
            }
            it("What is the highest signal that can be sent to the thrusters?") {
                day07.part1(DayInput().text(day07)) shouldBe 30940
            }
        }
        xcontext("part 2") {
            it("Max thruster signal from given phase setting sequence") {
                day07.part2(TextFromString("3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5"), listOf(9, 8, 7, 6, 5)) shouldBe 139629729
                day07.part2(TextFromString("3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10"), listOf(9, 7, 8, 5, 6)) shouldBe 18216
            }
            it("What is the highest signal that can be sent to the thrusters?") {
                // >28723
                day07.part2(DayInput().text(day07)) shouldBe 0
            }
        }
    }
})
