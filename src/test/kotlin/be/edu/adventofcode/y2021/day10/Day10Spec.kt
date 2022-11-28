package be.edu.adventofcode.y2021.day10

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

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
                assertEquals(26397, day10.part1(testInput))
            }
            it("Part 1 - Solution - What is the total syntax error score for those errors?") {
                assertEquals(392421, day10.part1(DayInput().lines(day10)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the middle score?") {
                assertEquals(288957, day10.part2(testInput))
            }
            it("Part 2 - Solution - What is the middle score?") {
                assertEquals(2769449099, day10.part2(DayInput().lines(day10)))
            }
        }
    }
})
