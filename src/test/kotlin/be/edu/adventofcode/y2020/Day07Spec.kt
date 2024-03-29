package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("Testcase - How many bag colors can eventually contain at least one shiny gold bag?") {
                day07.part1(
                    LinesFromArray(
                        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                        "bright white bags contain 1 shiny gold bag.",
                        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                        "faded blue bags contain no other bags.",
                        "dotted black bags contain no other bags.",
                    )
                ) shouldBe 4
            }
            it("Part 1 - How many bag colors can eventually contain at least one shiny gold bag?") {
                day07.part1(DayInput().lines(day07)) shouldBe 248
            }
        }
        context("part 2") {
            it("Exercise 1 - How many individual bags are required inside your single shiny gold bag?") {
                day07.part2(
                    LinesFromArray(
                        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                        "bright white bags contain 1 shiny gold bag.",
                        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                        "faded blue bags contain no other bags.",
                        "dotted black bags contain no other bags.",
                    )
                ) shouldBe 32
            }
            it("Exercise 2 - How many individual bags are required inside your single shiny gold bag?") {
                day07.part2(
                    LinesFromArray(
                        "shiny gold bags contain 2 dark red bags.",
                        "dark red bags contain 2 dark orange bags.",
                        "dark orange bags contain 2 dark yellow bags.",
                        "dark yellow bags contain 2 dark green bags.",
                        "dark green bags contain 2 dark blue bags.",
                        "dark blue bags contain 2 dark violet bags.",
                        "dark violet bags contain no other bags."
                    )
                ) shouldBe 126
            }
            it("Part 2 - How many individual bags are required inside your single shiny gold bag?") {
                day07.part2(DayInput().lines(day07)) shouldBe 57281
            }
        }
    }
})
