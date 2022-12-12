package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import java.math.BigInteger

class Day11 {
    fun part1(input: Lines): Int {
        val monkeys = input.get().chunked(7).map { Monkey.parse(it) }
        repeat(20) {
            monkeys.forEach { it.takeTurn(monkeys) }
        }
        return monkeys.map { it.inspectionCount.count }.sorted().takeLast(2).let { it.first() * it.last() }
    }

    fun part2(input: Lines): Long {
        val monkeys = input.get().chunked(7).map { Monkey.parseNoMultiply(it) }
        repeat(10000) {
            monkeys.forEach { it.takeTurnNoRelief(monkeys) }
        }
        monkeys.forEach { println(it.items) }
        val counts = monkeys.map { it.inspectionCount.count.toLong() }
        counts.zip(
            listOf(
                "Monkey 0 inspected items 52166 times.",
                "Monkey 1 inspected items 47830 times.",
                "Monkey 2 inspected items 1938 times.",
                "Monkey 3 inspected items 52013 times."
            )
        ) { a, e -> "Expected: $e Actual: $a" }.forEach { println(it) }
        return counts.sorted().takeLast(2).let { it.first() * it.last() }
    }

    data class Monkey(val id: Int, val items: MutableList<BigInteger>, val inspectOperation: (BigInteger) -> BigInteger, val testDivisor: BigInteger, val nextMonkey: Pair<Int, Int>, val inspectionCount: InspectionCount = InspectionCount()) {
        companion object {
            fun parse(input: List<String>): Monkey {
                val id = input[0].substringAfter("Monkey ").dropLast(1).toInt()
                val items = input[1].trim().substringAfter("Starting items: ").split(", ").map { it.toBigInteger() }.toMutableList()
                val tempOperation = input[2].trim().substringAfter("Operation: new = old ")
                val term = tempOperation.drop(2)
                val inspectOperation =
                    if (tempOperation == "* old") { x: BigInteger -> x * x }
                    else if (tempOperation.startsWith("+")) { x: BigInteger -> x + term.toBigInteger() }
                    else if (tempOperation.startsWith("*")) { x: BigInteger -> x * term.toBigInteger() }
                    else throw IllegalArgumentException(tempOperation)
                val testDivisor = input[3].substringAfterLast(' ').toBigInteger()
                val nextMonkey = input[4].substringAfterLast(' ').toInt() to input[5].substringAfterLast(' ').toInt()
                return Monkey(id, items, inspectOperation, testDivisor, nextMonkey)
            }

            fun parseNoMultiply(input: List<String>): Monkey {
                val id = input[0].substringAfter("Monkey ").dropLast(1).toInt()
                val items = input[1].trim().substringAfter("Starting items: ").split(", ").map { it.toBigInteger() }.toMutableList()
                val tempOperation = input[2].trim().substringAfter("Operation: new = old ")
                val term = tempOperation.drop(2)
                val inspectOperation =
                    if (tempOperation == "* old") { x: BigInteger -> x }   // no need to multiply when checking modulus only
                    else if (tempOperation.startsWith("+")) { x: BigInteger -> x + term.toBigInteger() }
                    else if (tempOperation.startsWith("*")) { x: BigInteger -> x }   // no need to multiply when checking modulus only
                    else throw IllegalArgumentException(tempOperation)
                val testDivisor = input[3].substringAfterLast(' ').toBigInteger()
                val nextMonkey = input[4].substringAfterLast(' ').toInt() to input[5].substringAfterLast(' ').toInt()
                return Monkey(id, items, inspectOperation, testDivisor, nextMonkey)
            }
        }

        fun takeTurn(monkeys: List<Monkey>) {
            takeTurn(monkeys) { x -> inspectOperation(x) / BigInteger.valueOf(3) }
        }

        fun takeTurnNoRelief(monkeys: List<Monkey>) {
            takeTurn(monkeys, inspectOperation)
        }

        private fun takeTurn(monkeys: List<Monkey>, inspectOperation: (BigInteger) -> BigInteger) {
            items.forEach { throwItem(monkeys, inspectOperation(it)) }
            inspectionCount.count += items.size
            items.clear()
        }

        private fun throwItem(monkeys: List<Monkey>, worryLevel: BigInteger) {
            /*
            Ik had gezien dat alle delers priemgetallen waren, dus heb ik voor de berekening modulo het product ervan gedaan.
            (Grootste gemene deler zou nog iets correcter zijn geweest.)
             */
            val targetMonkey = if (worryLevel.mod(testDivisor) == BigInteger.ZERO) nextMonkey.first else nextMonkey.second
            monkeys[targetMonkey].items.add(worryLevel)
        }

        class InspectionCount(var count: Int = 0) {
            override fun toString(): String {
                return "InspectionCount(count=$count)"
            }
        }
    }
}
