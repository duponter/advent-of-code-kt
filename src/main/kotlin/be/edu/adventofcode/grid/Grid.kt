package be.edu.adventofcode.grid

class Grid<T>(private val layout: List<List<T>>) {
    fun contains(point: Point): Boolean {
        val (x, y) = point.coordinates()
        return contains(x, y)
    }

    private fun contains(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < this.layout.size && y < this.layout[x].size
    }

    fun value(point: Point): T? {
        val (x, y) = point.coordinates()
        return if (contains(x, y)) this.layout[x][y] else null
    }

    fun replace(point: Point, newValue: T): Pair<Grid<T>, T?> {
        val (x, y) = point.coordinates()
        if (contains(x, y)) {
            val row = this.layout[x].toMutableList()
            val oldValue = row[y]
            row[y] = newValue
            val newLayout = this.layout.toMutableList()
            newLayout[x] = row
            return Grid(newLayout.toList()) to oldValue
        }
        return this to null
    }

    fun print(formatter: (T) -> String = { it.toString() }) {
        this.layout.forEach { it.forEach { value -> formatter(value) } }
    }
}
