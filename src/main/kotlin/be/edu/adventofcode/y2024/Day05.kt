package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int {
        // parse page orders
        val pageOrders = input.get().takeWhile { it.isNotBlank() }
            .map { it.split('|').map { s -> s.toInt() }.toSet() }

        // parse updates
        val updates = input.get().drop(pageOrders.size + 1)
            .map { it.split(',').map { s -> s.toInt() } }

        // select valid updates
        return updates.filter {
            pageOrders.all { po ->
                val intersect = it intersect po
                intersect.size < 2 || (intersect.first() == po.first() && intersect.last() == po.last())
            }
        }.sumOf { it[(it.size - 1) / 2] }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}
