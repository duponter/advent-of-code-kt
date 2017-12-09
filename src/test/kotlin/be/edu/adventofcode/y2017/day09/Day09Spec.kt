package be.edu.adventofcode.y2017.day09

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day09Spec : Spek({
    given("day 09") {
        val day09 = Day09()
        on("part 1") {
            it("{}, score of 1.") {
                assertEquals(1, day09.part1(TextFromString("{}")))
            }
            it("{{{}}}, score of 1 + 2 + 3 = 6.") {
                assertEquals(6, day09.part1(TextFromString("{{{}}}")))
            }
            it("{{},{}}, score of 1 + 2 + 2 = 5.") {
                assertEquals(5, day09.part1(TextFromString("{{},{}}")))
            }
            it("{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.") {
                assertEquals(16, day09.part1(TextFromString("{{{},{},{{}}}}")))
            }
            it("{<a>,<a>,<a>,<a>}, score of 1.") {
                assertEquals(1, day09.part1(TextFromString("{<a>,<a>,<a>,<a>}")))
            }
            it("{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.") {
                assertEquals(9, day09.part1(TextFromString("{{<ab>},{<ab>},{<ab>},{<ab>}}")))
            }
            it("{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.") {
                assertEquals(9, day09.part1(TextFromString("{{<!!>},{<!!>},{<!!>},{<!!>}}")))
            }
            it("{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3") {
                assertEquals(3, day09.part1(TextFromString("{{<a!>},{<a!>},{<a!>},{<ab>}}")))
            }
            it("should answer What is the total score for all groups in your input?") {
                assertEquals(20530, day09.part1(DayInput().text(day09)))
            }
        }
        on("part 2") {
            it("<>, 0 characters.") {
                assertEquals(0, day09.part2(TextFromString("<>")))
            }
            it("<random characters>, 17 characters.") {
                assertEquals(17, day09.part2(TextFromString("<random characters>")))
            }
            it("<<<<>, 3 characters.") {
                assertEquals(3, day09.part2(TextFromString("<<<<>")))
            }
            it("<{!>}>, 2 characters.") {
                assertEquals(2, day09.part2(TextFromString("<{!>}>")))
            }
            it("<!!>, 0 characters.") {
                assertEquals(0, day09.part2(TextFromString("<!!>")))
            }
            it("<!!!>>, 0 characters.") {
                assertEquals(0, day09.part2(TextFromString("<!!!>>")))
            }
            it("<{o\"i!a,<{i<a>, 10 characters.") {
                assertEquals(10, day09.part2(TextFromString("<{o\"i!a,<{i<a>")))
            }
            it("should answer How many non-canceled characters are within the garbage in your puzzle input?") {
                assertEquals(9978, day09.part2(DayInput().text(day09)))
            }
        }
    }
})
