package be.edu.adventofcode.y2019.day08

import be.edu.adventofcode.Text

class Day08 {
    fun part1(input: Text): Int {
        val image = Image(25, 6)
        val layer = image.asLayers(input.get().map { it.toString().toInt() })
                .minByOrNull { it.countDigit(0) }!!
        return layer.countDigit(1) * layer.countDigit(2)
    }

    fun part2(input: Text): Int {
        val image = Image(25, 6)
        val layer = image.flatten(input.get().map { it.toString().toInt() })
        layer.print()
        return layer.pixels.flatten().count()
    }
}

class Image(private val width: Int, private val height: Int) {
    fun asLayers(digits: List<Int>): List<Layer> {
        return digits.chunked(width * height) { it.chunked(width) }
                .map { Layer(it) }
    }

    fun flatten(digits: List<Int>): Layer {
        val layerSize = width * height
        val layers: List<List<Int>> = digits.chunked(layerSize)
        val vertical = mutableListOf<Int>()
        for (i in 0 until layerSize) {
            vertical.add(layers.map { it[i] }.dropWhile { it == 2 }.first())
        }
        assert(vertical.size == layerSize) { "${vertical.size} should be $layerSize" }
        return Layer(vertical.chunked(width))
    }
}

data class Layer(val pixels: List<List<Int>>) {
    fun countDigit(digit: Int): Int = pixels.flatten().count { it == digit }

    fun content(): String {
        return pixels.joinToString("") { it.joinToString("") }
    }

    fun print() {
        val visible = arrayOf("  ", "XX")
        pixels.map { it.joinToString("") { pixel -> visible[pixel] } }.forEach { println(it) }
    }
}
