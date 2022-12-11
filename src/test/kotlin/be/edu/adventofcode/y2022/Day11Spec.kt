package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day11Spec : DescribeSpec({
    describe("day 11") {
        val day11 = Day11()
        val testInput = LinesFromArray(
            "Monkey 0:",
            "  Starting items: 79, 98",
            "  Operation: new = old * 19",
            "  Test: divisible by 23",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 3",
            "",
            "Monkey 1:",
            "  Starting items: 54, 65, 75, 74",
            "  Operation: new = old + 6",
            "  Test: divisible by 19",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 0",
            "",
            "Monkey 2:",
            "  Starting items: 79, 60, 97",
            "  Operation: new = old * old",
            "  Test: divisible by 13",
            "    If true: throw to monkey 1",
            "    If false: throw to monkey 3",
            "",
            "Monkey 3:",
            "  Starting items: 74",
            "  Operation: new = old + 3",
            "  Test: divisible by 17",
            "    If true: throw to monkey 0",
            "    If false: throw to monkey 1"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the level of monkey business after 20 rounds of stuff-slinging simian shenanigans?") {
                day11.part1(testInput) shouldBe 10605
            }
            it("Part 1 - Solution - What is the level of monkey business after 20 rounds of stuff-slinging simian shenanigans?") {
                day11.part1(DayInput().lines(day11)) shouldBe 54054
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day11.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day11.part2(DayInput().lines(day11)) shouldBe 0
            }
        }
    }
})
