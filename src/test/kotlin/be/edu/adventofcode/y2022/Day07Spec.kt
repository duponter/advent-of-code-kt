package be.edu.adventofcode.y2022

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        val testInput = LinesFromArray(
            "$ cd /",
            "$ ls",
            "dir a",
            "14848514 b.txt",
            "8504156 c.dat",
            "dir d",
            "$ cd a",
            "$ ls",
            "dir e",
            "29116 f",
            "2557 g",
            "62596 h.lst",
            "$ cd e",
            "$ ls",
            "584 i",
            "$ cd ..",
            "$ cd ..",
            "$ cd d",
            "$ ls",
            "4060174 j",
            "8033020 d.log",
            "5626152 d.ext",
            "7214296 k"
        )
        context("part 1") {
            it("Part 1 - Testcase - What is the sum of the total sizes of directories with a total size of at most 100000?") {
                day07.part1(testInput) shouldBe 95437
            }
            it("Part 1 - Solution - What is the sum of the total sizes of directories with a total size of at most 100000?") {
                day07.part1(DayInput().lines(day07)) shouldBe 1307902
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day07.part2(testInput) shouldBe 0
            }
            it("Part 2 - Solution - ") {
                day07.part2(DayInput().lines(day07)) shouldBe 0
            }
        }
    }
})
