package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day05 {
    fun part1(input: Lines): Int {
        // parse page orders
        val pageOrders = parsePageOrders(input)

        // parse updates
        val updates = parseUpdates(input, pageOrders)

        // select valid updates
        return updates.filter {
            pageOrders.all { po ->
                val intersect = it intersect po
                intersect.size < 2 || (intersect.first() == po.first() && intersect.last() == po.last())
            }
        }.sumOf { it[(it.size - 1) / 2] }
    }

    fun part2(input: Lines): Int {
        // parse page orders
        val pageOrders = parsePageOrders(input)

        // parse updates
        val updates = parseUpdates(input, pageOrders)

        // select invalid updates
        val pairs = updates.filter {
            !pageOrders.all { po ->
                val intersect = it intersect po
                intersect.size < 2 || (intersect.first() == po.first() && intersect.last() == po.last())
            }
        }
            .map {
                it to pageOrders.filter { po ->
                    val intersect = it intersect po
                    intersect.size == 2 && intersect.first() == po.last()
                }
            }
        return pairs
            .map { it.first }
            .sumOf { it[(it.size - 1) / 2] }
    }

    private fun parsePageOrders(input: Lines): List<Set<Int>> {
        val pageOrders = input.get().takeWhile { it.isNotBlank() }
            .map { it.split('|').map { s -> s.toInt() }.toSet() }
        return pageOrders
    }

    private fun parseUpdates(input: Lines, pageOrders: List<Set<Int>>): List<List<Int>> {
        val updates = input.get().drop(pageOrders.size + 1)
            .map { it.split(',').map { s -> s.toInt() } }
        return updates
    }
}
