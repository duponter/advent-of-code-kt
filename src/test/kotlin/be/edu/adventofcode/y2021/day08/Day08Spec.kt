package be.edu.adventofcode.y2021.day08

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals

class Day08Spec : DescribeSpec({
    describe("day 08") {
        val day08 = Day08()
        val testInput = LinesFromArray(
            "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe",
            "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc",
            "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg",
            "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb",
            "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea",
            "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb",
            "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe",
            "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef",
            "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb",
            "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"
        )
        context("part 1") {
            it("Part 1 - Testcase - In the output values, how many times do digits 1, 4, 7, or 8 appear?") {
                assertEquals(26, day08.part1(testInput))
            }
            it("Part 1 - Solution - In the output values, how many times do digits 1, 4, 7, or 8 appear?") {
                assertEquals(392, day08.part1(DayInput().lines(day08)))
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What do you get if you add up all of the output values?") {
                assertEquals(61229, day08.part2(testInput))
            }
            it("Part 2 - Solution - What do you get if you add up all of the output values?") {
                assertEquals(1004688, day08.part2(DayInput().lines(day08)))
            }
        }
    }
})
