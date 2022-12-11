package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines

class Day11 {
    fun part1(input: Lines): Int {
        val monkeys = input.get().chunked(7).map { Monkey.parse(it) }
        repeat(20) {
            monkeys.forEach { it.takeTurn(monkeys) }
        }
        return monkeys.map { it.inspectionCount.count }.sorted().takeLast(2).let { it.first() * it.last() }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }

    data class Monkey(val id: Int, val items: MutableList<Int>, val inspectOperation: (Int) -> Int, val testDivisor: Int, val nextMonkey: Pair<Int, Int>, val inspectionCount: InspectionCount = InspectionCount()) {
        companion object {
            fun parse(input: List<String>): Monkey {
                val id = input[0].substringAfter("Monkey ").dropLast(1).toInt()
                val items = input[1].trim().substringAfter("Starting items: ").split(", ").map { it.toInt() }.toMutableList()
                val tempOperation = input[2].trim().substringAfter("Operation: new = old ")
                val term = tempOperation.drop(2)
                val inspectOperation =
                    if (tempOperation == "* old") { x: Int -> x * x }
                    else if (tempOperation.startsWith("+")) { x: Int -> x + term.toInt() }
                    else if (tempOperation.startsWith("*")) { x: Int -> x * term.toInt() }
                    else throw IllegalArgumentException(tempOperation)
                val testDivisor = input[3].substringAfterLast(' ').toInt()
                val nextMonkey = input[4].substringAfterLast(' ').toInt() to input[5].substringAfterLast(' ').toInt()
                return Monkey(id, items, inspectOperation, testDivisor, nextMonkey)
            }
        }

        fun takeTurn(monkeys: List<Monkey>) {
            items.forEach { inspectItem(monkeys, it) }
            inspectionCount.count += items.size
            items.clear()
        }

        private fun inspectItem(monkeys: List<Monkey>, item: Int) {
            val worryLevel: Int = inspectOperation(item) / 3
            val targetMonkey = if (worryLevel % testDivisor == 0) nextMonkey.first else nextMonkey.second
            monkeys[targetMonkey].items.add(worryLevel)
        }

        class InspectionCount(var count: Int = 0) {
            override fun toString(): String {
                return "InspectionCount(count=$count)"
            }
        }
    }

}
