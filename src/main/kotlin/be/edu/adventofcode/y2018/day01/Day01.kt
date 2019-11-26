package be.edu.adventofcode.y2018.day01

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return input.get()
                .map { it.toInt() }
                .sum()
    }

	fun part2(input: Lines): Int {
        println("implementation = incomplete")
        val list = input.get()
                .map { it.toInt() }
                .asSequence()
                .fold(mutableListOf(0)) { acc, i -> acc.apply { acc.add(acc.last() + i) } }

        println("start")
        list.forEach { print(it) }

        val frequencies = mutableSetOf<Int>()
        list.dropWhile { next -> frequencies.add(next) }

//        list.drX
        println("end")
        return list.first();
    }
}
