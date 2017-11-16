package be.edu.adventofcode.y2015.day04

import be.edu.adventofcode.Text
import java.security.MessageDigest

class Day04 {
    fun part1(input: Text): Int {
        val md = MessageDigest.getInstance("MD5")
        return generateSequence(1, { it + 1 })
                .map { Pair(it, String.format("%s%d", input.get(), it).hash(md)) }
                .dropWhile { !it.second.startsWith("00000") }
                .first()
                .first
    }

    fun part2(input: Text): Int {
        val md = MessageDigest.getInstance("MD5")
        return generateSequence(1, { it + 1 })
                .map { Pair(it, String.format("%s%d", input.get(), it).hash(md)) }
                .dropWhile { !it.second.startsWith("000000") }
                .first()
                .first
    }

    fun String.hash(messageDigest: MessageDigest): String {
        val digested = messageDigest.digest(toByteArray())
        return digested.joinToString("") {
            String.format("%02x", it)
        }
    }
}