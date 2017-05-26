package be.edu.adventofcode

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object CalculatorSpec : Spek({
    given("a calculator") {
        val calculator = Calculator()
        on("addition") {
            val sum = calculator.add(2, 4)
            it("should return the result of adding the first number to the second number") {
                assertEquals(6, sum)
            }
        }
        on("subtraction") {
            val subtract = calculator.subtract(4, 2)
            it("should return the result of subtracting the second number from the first number") {
                assertEquals(2, subtract)
            }
        }
    }
})
