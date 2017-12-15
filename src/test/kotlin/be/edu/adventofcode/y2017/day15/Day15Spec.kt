package be.edu.adventofcode.y2017.day15

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day15Spec : Spek({
    given("day 15") {
        val day15 = Day15()
        on("part 1") {
            it("After processing these five pairs, the judge would have added only 1 to its total.") {
                assertEquals(1, day15.part1(Pair(65, 8921), 5))
            }
            it("The judge would eventually find a total of 588 pairs that match in their lowest 16 bits") {
                assertEquals(588, day15.part1(Pair(65, 8921), 40000000))
            }
            it("should answer After 40 million pairs, what is the judge's final count?") {
                assertEquals(573, day15.part1(Pair(634, 301), 40000000))
            }
        }
        on("part 2") {
            it("After five million pairs, the judge would eventually find a total of 309 pairs that match in their lowest 16 bits.") {
                assertEquals(309, day15.part2(Pair(65, 8921), 5000000))
            }
            it("should answer After 5 million pairs, but using this new generator logic, what is the judge's final count?") {
                assertEquals(294, day15.part2(Pair(634, 301), 5000000))
            }
        }
    }
})
