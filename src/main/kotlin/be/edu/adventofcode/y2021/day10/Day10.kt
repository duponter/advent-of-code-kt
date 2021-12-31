package be.edu.adventofcode.y2021.day10

import be.edu.adventofcode.Lines

class Day10 {
    fun part1(input: Lines): Int {
        return input.get()
            .map { Line.parse(it) }
            .sumOf { it.errorScore() }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

interface Chunk {
    fun openChunk(char: Char): Chunk

    fun closeChunk(char: Char): Chunk

    fun isIncomplete(): Boolean

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
        return this;
    }

    override fun closeChunk(char: Char): Line {
        if (chunks.isEmpty()) {
            throw IllegalArgumentException("Cannot close empty Line with $char")
        }
        chunks[chunks.size - 1] = chunks.last().closeChunk(char)
        return this
    }

    override fun isIncomplete(): Boolean = chunks.last().isIncomplete()

    override fun isCorrupted(): Boolean = chunks.any { it.isCorrupted() }

    override fun errorScore(): Int {
        return chunks.firstOrNull { it.isCorrupted() }?.errorScore() ?: 0
    }
}

data class OpenChunk(val open: Char, val chunks: MutableList<Chunk>) : Chunk {
    constructor(open: Char) : this(open, mutableListOf())

    override fun isIncomplete(): Boolean = true

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
