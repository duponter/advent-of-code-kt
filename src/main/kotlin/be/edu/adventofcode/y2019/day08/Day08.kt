package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.Text

class Day08 {
    fun part1(input: Text): Int {
        val image = Image(25, 6)
        val layer = image.asLayers(input.get().map { it.toString().toInt() })
                .minBy { it.countDigit(0) }!!
        return layer.countDigit(1) * layer.countDigit(2)
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}

class Image(private val width: Int, private val height: Int) {
    fun asLayers(digits: List<Int>): List<Layer> {
        return digits.chunked(width * height) { it.chunked(width) }
                .map { Layer(it) }
    }
}

data class Layer(val pixels: List<List<Int>>) {
    fun countDigit(digit: Int): Int = pixels.flatten().count { it == digit }
}
