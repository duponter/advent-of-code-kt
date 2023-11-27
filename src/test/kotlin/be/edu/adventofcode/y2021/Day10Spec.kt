package be.edu.adventofcode.y2021

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day10Spec : DescribeSpec({
    describe("day 10") {
        val day10 = Day10()
        val testInput = LinesFromArray(
            "[({(<(())[]>[[{[]{<()<>>",
            "[(()[<>])]({[<{<<[]>>(",
            "{([(<{}[<>[]}>{[]{[(<()>",
            "(((({<>}<{<{<>}{[]{[]{}",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "{<[[]]>}<{[{[{[]{()[[[]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{",
            "<{([{{}}[<[[[<>{}]]]>[]]"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the total syntax error score for those errors?") {
                day10.part1(testInput) shouldBe 26397
            }
            it("Part 1 - Solution - What is the total syntax error score for those errors?") {
                day10.part1(DayInput().lines(day10)) shouldBe 392421
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the middle score?") {
                day10.part2(testInput) shouldBe 288957
            }
            it("Part 2 - Solution - What is the middle score?") {
                day10.part2(DayInput().lines(day10)) shouldBe 2769449099
            }
        }
    }
})
