package be.edu.adventofcode.y2015.day02

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day02Spec : Spek({
    given("examples day 02 part 1") {
        assertEquals(52, Present(2, 3, 4).surfaceArea())
        assertEquals(6, Present(2, 3, 4).smallestSideArea())
        assertEquals(42, Present(1, 1, 10).surfaceArea())
        assertEquals(1, Present(1, 1, 10).smallestSideArea())
    }
    given("examples day 02 part 2") {
        assertEquals(10, Present(2, 3, 4).shortestDistance())
        assertEquals(24, Present(2, 3, 4).volume())
        assertEquals(4, Present(1, 1, 10).shortestDistance())
        assertEquals(10, Present(1, 1, 10).volume())
    }
    given("day 02") {
        val day02 = Day02();
        on("part 1") {
            val squareFeet = day02.part1()
            it("should answer How many total square feet of wrapping paper should they order?") {
                assertEquals(1586300, squareFeet)
            }
        }
        on("part 2") {
            val position = day02.part2()
            it("should answer How many total feet of ribbon should they order?") {
                assertEquals(3737498, position)
            }
        }
    }
})