package be.edu.adventofcode

import java.io.File

interface Text {
    fun get(): String

    fun chars(): List<Char> = get().toList()
}

class TextFromFile(private val file: File) : Text {

    override fun get(): String = file.readText()

}

class TextFromString(private val input: String) : Text {
    override fun get(): String = input
}