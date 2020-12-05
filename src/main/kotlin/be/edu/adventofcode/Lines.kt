package be.edu.adventofcode

import java.io.File

interface Lines {
    fun get(): List<String>

    fun asSequence(): Sequence<String> = get().asSequence()
}

class LinesFromFile(private val file: File) : Lines {
    override fun get(): List<String> = file.readLines()
}

class LinesFromArray(private vararg val lines: String) : Lines {
    override fun get(): List<String> = lines.asList()
}

