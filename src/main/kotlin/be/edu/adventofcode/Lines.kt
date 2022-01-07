package be.edu.adventofcode

import java.io.File

interface Lines {
    fun get(): List<String>

    fun digits(): List<List<Int>> = get().map { line -> line.map { it.digitToInt() } }
}

class LinesFromFile(private val file: File) : Lines {
    override fun get(): List<String> = file.readLines()
}

class LinesFromArray(private vararg val lines: String) : Lines {
    override fun get(): List<String> = lines.asList()
}

