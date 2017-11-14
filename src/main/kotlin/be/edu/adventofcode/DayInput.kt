package be.edu.adventofcode

import java.io.File


class DayInput {
    fun lines(instance: Any): List<String> = LinesFromFile(inputFile(instance)).get()

    fun text(instance: Any): String = TextFromFile(inputFile(instance)).get()

    fun chars(instance: Any): List<Char> = TextFromFile(inputFile(instance)).chars()

    private fun inputFile(instance: Any): File = File(instance.javaClass.getResource("${instance.javaClass.simpleName}.txt").toURI())
}