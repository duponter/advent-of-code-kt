package be.edu.adventofcode

import java.io.File


class DayInput {
    fun lines(instance: Any): Lines = LinesFromFile(inputFile(instance))

    fun text(instance: Any): Text = TextFromFile(inputFile(instance))

    private fun inputFile(instance: Any): File = File(instance.javaClass.getResource("${instance.javaClass.simpleName}.txt").toURI())
}