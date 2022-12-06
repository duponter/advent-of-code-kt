package be.edu.adventofcode.y2022

import be.edu.adventofcode.Text

class Day06 {
    fun part1(input: Text): Int = indexAfterMarkerOfCharCount(input.get(), 4)

    fun part2(input: Text): Int = indexAfterMarkerOfCharCount(input.get(), 14)

    private fun indexAfterMarkerOfCharCount(datastream: String, count: Int): Int {
        val marker = datastream.windowedSequence(count).toList().first { it.toSet().size == count }
        return datastream.length - datastream.substringAfter(marker).length
    }
}
