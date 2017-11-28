package be.edu.adventofcode.y2015.day05

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day05Spec : Spek({
    given("day 05") {
        val day05 = Day05()
        on("part 1") {
            it("ugknbfddgicrmopn is nice") {
                assertEquals(1, day05.part1(LinesFromArray("ugknbfddgicrmopn")))
            }
            it("aaa is nice") {
                assertEquals(1, day05.part1(LinesFromArray("aaa")))
            }
            it("jchzalrnumimnmhp is naughty") {
                assertEquals(0, day05.part1(LinesFromArray("jchzalrnumimnmhp")))
            }
            it("haegwjzuvuyypxyu is naughty") {
                assertEquals(0, day05.part1(LinesFromArray("haegwjzuvuyypxyu")))
            }
            it("dvszwmarrgswjxmb is naughty") {
                assertEquals(0, day05.part1(LinesFromArray("dvszwmarrgswjxmb")))
            }
            it("should answer How many strings are nice?") {
                assertEquals(236, day05.part1(DayInput().lines(day05)))
            }
        }
        on("part 2") {
            it("qjhvhtzxzqqjkmpb is nice") {
                assertEquals(1, day05.part2(LinesFromArray("qjhvhtzxzqqjkmpb")))
            }
            it("xxyxx is nice") {
                assertEquals(1, day05.part2(LinesFromArray("xxyxx")))
            }
            it("uurcxstgmygtbstg is naughty") {
                assertEquals(0, day05.part2(LinesFromArray("uurcxstgmygtbstg")))
            }
            it("ieodomkazucvgmuy is naughty") {
                assertEquals(0, day05.part2(LinesFromArray("ieodomkazucvgmuy")))
            }
            it("should answer How many strings are nice under these new rules?") {
                assertEquals(51, day05.part2(DayInput().lines(day05)))
            }
        }
    }
})
