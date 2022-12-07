package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines

class Day10 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { Line.parse(it) }
            .sumOf { it.errorScore() }
    }

    fun part2(input: Lines): Long {
        return input.get()
            .map { Line.parse(it) }
            .filter { !it.isCorrupted() }
            .map { it.completionScore() }
            .sorted()
            .median()
    }

    fun List<Long>.median(): Long = if (this.size % 2 == 0) {
        (this[this.size / 2] + this[this.size / 2 - 1]) / 2
    } else {
        this[this.size / 2]
    }

    interface Chunk {
        fun openChunk(char: Char): Chunk

        fun closeChunk(char: Char): Chunk

        fun isIncomplete(): Boolean

        fun toComplete(): String

        fun isCorrupted(): Boolean

        fun errorScore(): Int
    }

    data class Line(val chunks: MutableList<Chunk>) : Chunk {
        companion object {
            fun parse(input: String): Line {
                return (input.fold(Line()) { line, char -> line.process(char) })
            }
        }

        constructor() : this(mutableListOf())

        fun process(char: Char): Line = if ("([{<".contains(char)) openChunk(char) else closeChunk(char)

        override fun openChunk(char: Char): Line {
            if (chunks.isEmpty() || !chunks.last().isIncomplete()) {
                chunks.add(OpenChunk(char))
            } else {
                chunks.last().openChunk(char)
            }
            return this
        }

        override fun closeChunk(char: Char): Line {
            if (chunks.isEmpty()) {
                throw IllegalArgumentException("Cannot close empty Line with $char")
            }
            chunks[chunks.size - 1] = chunks.last().closeChunk(char)
            return this
        }

        override fun isIncomplete(): Boolean = chunks.last().isIncomplete()

        override fun toComplete(): String = if (chunks.isEmpty() || !chunks.last().isIncomplete()) "" else chunks.last().toComplete()

        fun completionScore(): Long {
            return toComplete().fold(0) { score, char ->
                score * 5 + when (char) {
                    ')' -> 1
                    ']' -> 2
                    '}' -> 3
                    '>' -> 4
                    else -> throw IllegalArgumentException("Unknown close character $char")
                }
            }
        }

        override fun isCorrupted(): Boolean = chunks.any { it.isCorrupted() }

        override fun errorScore(): Int {
            return chunks.firstOrNull { it.isCorrupted() }?.errorScore() ?: 0
        }
    }

    data class OpenChunk(val open: Char, val chunks: MutableList<Chunk>) : Chunk {
        constructor(open: Char) : this(open, mutableListOf())

        override fun isIncomplete(): Boolean = true

        override fun toComplete(): String {
            val completeThis = when (open) {
                '(' -> ")"
                '[' -> "]"
                '{' -> "}"
                '<' -> ">"
                else -> throw IllegalArgumentException("Unknown open character $open")
            }
            return if (chunks.isEmpty() || !chunks.last().isIncomplete()) {
                completeThis
            } else {
                chunks.last().toComplete() + completeThis
            }
        }

        override fun isCorrupted(): Boolean = chunks.any { it.isCorrupted() }

        override fun errorScore(): Int {
            return chunks.firstOrNull { it.isCorrupted() }?.errorScore() ?: 0
        }

        override fun openChunk(char: Char): Chunk {
            if (chunks.isEmpty() || !chunks.last().isIncomplete()) {
                chunks.add(OpenChunk(char))
            } else {
                chunks.last().openChunk(char)
            }
            return this
        }

        override fun closeChunk(char: Char): Chunk {
            if (chunks.isEmpty() || !chunks.last().isIncomplete()) {
                return ClosedChunk(open, chunks, char)
            }
            chunks[chunks.size - 1] = chunks.last().closeChunk(char)
            return this
        }
    }

    data class ClosedChunk(val open: Char, val chunks: List<Chunk>, val close: Char) : Chunk {
        override fun isIncomplete(): Boolean = false

        override fun toComplete(): String = ""

        override fun isCorrupted(): Boolean = chunks.any { it.isCorrupted() } || when (open) {
            '(' -> close != ')'
            '[' -> close != ']'
            '{' -> close != '}'
            '<' -> close != '>'
            else -> throw IllegalArgumentException("Unknown open character $open")
        }

        override fun errorScore(): Int = if (isCorrupted()) {
            chunks.firstOrNull { it.isCorrupted() }?.errorScore() ?: when (close) {
                ')' -> 3
                ']' -> 57
                '}' -> 1197
                '>' -> 25137
                else -> throw IllegalArgumentException("Unknown close character $close")
            }
        } else {
            0
        }

        override fun openChunk(char: Char): Chunk {
            throw IllegalArgumentException("Cannot open ClosedChunk with $char")
        }

        override fun closeChunk(char: Char): Chunk {
            throw IllegalArgumentException("Cannot close ClosedChunk with $char")
        }
    }
}
