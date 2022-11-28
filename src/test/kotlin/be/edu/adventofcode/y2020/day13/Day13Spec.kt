package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day13Spec : DescribeSpec({
    describe("day 13") {
        val day13 = Day13()
        context("part 1") {
            it("Part 1 - Testcase - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                day13.part1(LinesFromArray("939", "7,13,x,x,59,x,31,19")) shouldBe 295
            }
            it("Part 1 - Solution - What is the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus?") {
                day13.part1(DayInput().lines(day13)) shouldBe 2165
            }
        }
        context("part 2") {
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("939", "7,13,x,x,59,x,31,19")) shouldBe 1068781
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("17,x,13,19")) shouldBe 3417
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("67,7,59,61")) shouldBe 754018
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("67,x,7,59,61")) shouldBe 779210
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("67,7,x,59,61")) shouldBe 1261476
            }
            it("Part 2 - Testcase - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(LinesFromArray("1789,37,47,1889")) shouldBe 1202161486
            }
            xit("Part 2 - Solution - What is the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list?") {
                day13.part2(DayInput().lines(day13), 100000000000000) shouldBe 0
            }
        }
    }
})






