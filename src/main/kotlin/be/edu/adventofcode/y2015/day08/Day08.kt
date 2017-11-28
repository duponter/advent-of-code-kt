package be.edu.adventofcode.y2015.day08

import be.edu.adventofcode.Lines

class Day08 {
    fun part1(input: Lines): Int {
        return input.get().map { Pair(it.length, it.trim('"').replace("\\\"", "\"").replace("\\\\", "\\").replace(Regex("\\\\[xX]([0-9a-fA-F]{2})"), { String(it.destructured.component1().hexStringToByteArray()) }).length) }
                .map { it.first - it.second }
                .sum()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

private const val HEX_CHARS = "0123456789ABCDEF"

fun String.hexStringToByteArray(): ByteArray {
    val result = ByteArray(length / 2)

    for (i in 0 until length step 2) {
        val firstIndex = HEX_CHARS.indexOf(this[i]);
        val secondIndex = HEX_CHARS.indexOf(this[i + 1]);

        val octet = firstIndex.shl(4).or(secondIndex)
        result[i.shr(1)] = octet.toByte()
    }

    return result
}
