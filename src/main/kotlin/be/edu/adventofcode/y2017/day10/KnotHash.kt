package be.edu.adventofcode.y2017.day10


class KnotHash {
    fun singleRound(current: Pair<List<Int>, Int>, skipSize: Int, length: Int): Pair<List<Int>, Int> {
        val numbers = current.first
        if (length > numbers.size) throw IllegalStateException("Length $length > Number list size ${numbers.size}")
        return Pair(numbers.reverseCycled(current.second, length), (current.second + length + skipSize) % numbers.size)
    }

    fun calculate(input: String, size: Int): String {
        val numbers = (0 until size).toList()
        return input.asIterable().map(Char::code) // every char of input to ASCII
            .plus(listOf(17, 31, 73, 47, 23))   // + ,17, 31, 73, 47, 23
            .repeat(64) // repeat new input 64 times ==> sparse hash
            .foldIndexed(Pair(numbers, 0), { index, acc, length -> singleRound(acc, index, length) })
            .first
            .chunked(16, { it.reduce { acc: Int, i: Int -> acc xor i } })
            .joinToString("") { it.toString(16).padStart(2, '0') }
    }
}
