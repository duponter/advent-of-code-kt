package be.edu.adventofcode.y2017.day16

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.dsl.xon
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

object Day16Spec : Spek({
    given("day 16") {
        val day16 = Day16()
        on("part 1") {
            it("After finishing their dance, the programs end up in order baedc.") {
                assertEquals("baedc", day16.part1("abcde", TextFromString("s1,x3/4,pe/b")))
            }
            it("should answer In what order are the programs standing after their dance?") {
                assertEquals("glnacbhedpfjkiom", day16.part1(CharRange('a', 'p').joinToString(""), DayInput().text(day16)))
            }
        }
        xon("part 2") {
            it("should answer In what order are the programs standing after their billion dances?") {
                val part2 = day16.part2(DayInput().text(day16))
                assertNotEquals("gbnacfhedjklmiop", part2)
                assertNotEquals("afcdekghilmbpnoj", part2)
                assertEquals("", part2)
            }
        }
    }
})
