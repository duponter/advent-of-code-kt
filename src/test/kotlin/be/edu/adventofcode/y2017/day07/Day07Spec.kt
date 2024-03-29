package be.edu.adventofcode.y2017.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("tknk is at the bottom of the tower (the bottom program)") {
                day07.part1(
                    LinesFromArray(
                        "pbga (66)",
                        "xhth (57)",
                        "ebii (61)",
                        "havc (66)",
                        "ktlj (57)",
                        "fwft (72) -> ktlj, cntj, xhth",
                        "qoyq (66)",
                        "padx (45) -> pbga, havc, qoyq",
                        "tknk (41) -> ugml, padx, fwft",
                        "jptl (61)",
                        "ugml (68) -> gyxo, ebii, jptl",
                        "gyxo (61)",
                        "cntj (57)"
                    )
                ) shouldBe "tknk"
            }
            it("should answer  What is the name of the bottom program?") {
                day07.part1(DayInput().lines(day07)) shouldBe "qibuqqg"
            }
        }
        context("part 2") {
            it("tknk's disc is unbalanced: ugml's weight would be 60.") {
                day07.part2(
                    LinesFromArray(
                        "pbga (66)",
                        "xhth (57)",
                        "ebii (61)",
                        "havc (66)",
                        "ktlj (57)",
                        "fwft (72) -> ktlj, cntj, xhth",
                        "qoyq (66)",
                        "padx (45) -> pbga, havc, qoyq",
                        "tknk (41) -> ugml, padx, fwft",
                        "jptl (61)",
                        "ugml (68) -> gyxo, ebii, jptl",
                        "gyxo (61)",
                        "cntj (57)"
                    )
                ) shouldBe 60
            }
            it("should answer What would its weight need to be to balance the entire tower?") {
                day07.part2(DayInput().lines(day07)) shouldNotBe 71
                day07.part2(DayInput().lines(day07)) shouldBe 1079
            }
        }
    }
})
