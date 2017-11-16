package be.edu.adventofcode.y2015.day04

import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.xit
import kotlin.test.assertEquals

object Day04Spec : Spek({
    given("day 04") {
        val day04 = Day04();
        on("part 1") {
            xit("If your secret key is abcdef, the lowest positive number is 609043") {
                assertEquals(609043, day04.part1(TextFromString("abcdef")))
            }
            xit("If your secret key is pqrstuv, the lowest positive number is 1048970") {
                assertEquals(1048970, day04.part1(TextFromString("pqrstuv")))
            }
            xit("should answer What is the lowest positive number that produces a hash starting with 5+ leading zeros?") {
                assertEquals(254575, day04.part1(TextFromString("bgvyzdsv")))
            }
        }
        on("part 2") {
            xit("should answer What is the lowest positive number that produces a hash starting with 6+ leading zeros?") {
                assertEquals(1038736, day04.part2(TextFromString("bgvyzdsv")))
            }
        }
    }
})
