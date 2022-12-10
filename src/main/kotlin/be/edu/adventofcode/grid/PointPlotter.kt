package be.edu.adventofcode.grid

import kotlin.math.abs


data class PointPlotter(val hit: String = "#", val miss: String = ".") {

    fun plot(points: List<Point>) {
        val minX = points.minOf { it.x() }
        val maxX = points.maxOf { it.x() }
        val minY = points.minOf { it.y() }
        val maxY = points.maxOf { it.y() }

        val lines = (maxY downTo minY)
            .map { y ->
                (minX..maxX).joinToString("", "${abs(y) % 10}$miss", "$miss${abs(y) % 10}") { x ->
                    if (points.contains(Point(x, y))) hit else miss
                }
            }

        val ruler = (minX - 1..maxX + 1)
            .joinToString("", " ", " ") { "${abs(it) % 10}" }
        val emptyLine = " " + ".".repeat(abs(minX - 1) + abs(maxX + 1) + 1) + " "

        val plot = listOf(ruler, emptyLine) + lines + listOf(emptyLine, ruler)

        plot.forEach { println(it) }
    }

}
