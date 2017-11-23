package be.edu.adventofcode.y2015.day07

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): Int {
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

fun main(args: Array<String>) {
    println("123 -> x")
    println("456 -> y")
    println("x AND y -> d")
    println("${123 and 456} -> d")
    println("x OR y -> e")
    println("${123 or 456} -> e")
    println("x LSHIFT 2 -> f")
    println("${123 shl 2} -> f")
    println("y RSHIFT 2 -> g")
    println("${456 shr 2} -> g")
    println("NOT x -> h")
    println("${Math.pow(2.0, 16.0).toInt() + 123.inv()} -> h")
    println("NOT y -> i")
    println("${Math.pow(2.0, 16.0).toInt() + 456.inv()} -> i")

}
