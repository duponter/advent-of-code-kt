package be.edu.adventofcode.y2015.day07

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day07Spec : DescribeSpec({
    describe("day 07") {
        val day07 = Day07()
        context("part 1") {
            it("signals on the wires of a simple circuit") {
                val map = day07.parseLines(
                    LinesFromArray(
                        "123 -> x",
                        "456 -> y",
                        "x AND y -> d",
                        "x OR y -> e",
                        "x LSHIFT 2 -> f",
                        "y RSHIFT 2 -> g",
                        "NOT x -> h",
                        "NOT y -> i"
                    )
                )
                map["d"]!!.connect { map[it]!! } shouldBe 72
                map["e"]!!.connect { map[it]!! } shouldBe 507
                map["f"]!!.connect { map[it]!! } shouldBe 492
                map["g"]!!.connect { map[it]!! } shouldBe 114
                map["h"]!!.connect { map[it]!! } shouldBe 65412
                map["i"]!!.connect { map[it]!! } shouldBe 65079
                map["y"]!!.connect { map[it]!! } shouldBe 456
                map["x"]!!.connect { map[it]!! } shouldBe 123

            }
            it("should answer What signal is ultimately provided to wire a?") {
                day07.part1(DayInput().lines(day07)) shouldBe 46065
            }
        }
        context("part 2") {
            it("should answer What new signal is ultimately provided to wire a?") {
                day07.part2(DayInput().lines(day07)) shouldBe 14134
            }
        }
    }
})
