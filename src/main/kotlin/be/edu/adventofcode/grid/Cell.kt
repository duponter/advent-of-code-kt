package be.edu.adventofcode.grid

interface Cell<T> {
    fun value(): T?

    fun replace(newValue: T?): Cell<T>

    fun <R> map(mapper: (row: Int, col: Int, value: T?) -> R): R

    fun north(grid: Grid<Cell<T>>): Cell<T>

    fun northEast(grid: Grid<Cell<T>>): Cell<T>

    fun east(grid: Grid<Cell<T>>): Cell<T>

    fun southEast(grid: Grid<Cell<T>>): Cell<T>

    fun south(grid: Grid<Cell<T>>): Cell<T>

    fun southWest(grid: Grid<Cell<T>>): Cell<T>

    fun west(grid: Grid<Cell<T>>): Cell<T>

    fun northWest(grid: Grid<Cell<T>>): Cell<T>

    fun adjacents(grid: Grid<Cell<T>>): List<Cell<T>> =
        listOf(
            northWest(grid), north(grid), northEast(grid),
            east(grid), west(grid),
            southEast(grid), south(grid), southWest(grid)
        )

//    fun adjacents(grid: Grid<Cell<T>>): List<Cell<T>> = listOf(
//        this.visit { it.northWest(grid) }, this.visit { it.north(grid) }, this.visit { it.northEast(grid) },
//        this.visit { it.east(grid) }, this.visit { it.west(grid) },
//        this.visit { it.southEast(grid) }, this.visit { it.south(grid) }, this.visit { it.southWest(grid) }
//    )

    fun visit(direction: (Cell<T>) -> Cell<T>): Cell<T> = direction(this).onVisit(direction)

    fun onVisit(direction: (Cell<T>) -> Cell<T>): Cell<T> = this
}

open class BasicCell<T>(private val row: Int, private val col: Int, private var value: T?) : Cell<T> {
    override fun value(): T? = this.value

    override fun replace(newValue: T?): Cell<T> = BasicCell(row, col, newValue)

    override fun <R> map(mapper: (row: Int, col: Int, value: T?) -> R): R = mapper(this.row, this.col, this.value)

    override fun north(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row - 1, col)

    override fun northEast(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row - 1, col + 1)

    override fun east(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row, col + 1)

    override fun southEast(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row + 1, col + 1)

    override fun south(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row + 1, col)

    override fun southWest(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row + 1, col - 1)

    override fun west(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row, col - 1)

    override fun northWest(grid: Grid<Cell<T>>): Cell<T> = grid.raw(row - 1, col - 1)

    override fun toString(): String = "BasicCell(row=$row, col=$col, value=$value)"
}

data class SkippingCell<T>(private val row: Int, private val col: Int, private val value: T?) : BasicCell<T>(row, col, value) {
    override fun replace(newValue: T?): Cell<T> = SkippingCell(row, col, newValue)

    override fun onVisit(direction: (Cell<T>) -> Cell<T>): Cell<T> = direction(this).onVisit(direction)
}

abstract class DelegatingCell<T>(private val delegate: Cell<T>) : Cell<T> {
    override fun value(): T? = this.delegate.value()

    override fun <R> map(mapper: (row: Int, col: Int, value: T?) -> R): R = this.delegate.map(mapper)

    override fun north(grid: Grid<Cell<T>>): Cell<T> = this.delegate.north(grid)

    override fun northEast(grid: Grid<Cell<T>>): Cell<T> = this.delegate.northEast(grid)

    override fun east(grid: Grid<Cell<T>>): Cell<T> = this.delegate.east(grid)

    override fun southEast(grid: Grid<Cell<T>>): Cell<T> = this.delegate.southEast(grid)

    override fun south(grid: Grid<Cell<T>>): Cell<T> = this.delegate.south(grid)

    override fun southWest(grid: Grid<Cell<T>>): Cell<T> = this.delegate.southWest(grid)

    override fun west(grid: Grid<Cell<T>>): Cell<T> = this.delegate.west(grid)

    override fun northWest(grid: Grid<Cell<T>>): Cell<T> = this.delegate.northWest(grid)

    override fun onVisit(direction: (Cell<T>) -> Cell<T>): Cell<T> = visit(direction)
}

data class NorthBorderCell<T>(val delegate: Cell<T>) : DelegatingCell<T>(delegate) {
    override fun replace(newValue: T?): Cell<T> = NorthBorderCell(this.delegate.replace(newValue))

    override fun north(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row - 1, col, null) }

    override fun northEast(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row - 1, col + 1, null) }

    override fun northWest(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row - 1, col - 1, null) }
}

data class EastBorderCell<T>(val delegate: Cell<T>) : DelegatingCell<T>(delegate) {
    override fun replace(newValue: T?): Cell<T> = EastBorderCell(this.delegate.replace(newValue))

    override fun northEast(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row - 1, col + 1, null) }

    override fun east(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row, col + 1, null) }

    override fun southEast(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row + 1, col + 1, null) }
}

data class SouthBorderCell<T>(val delegate: Cell<T>) : DelegatingCell<T>(delegate) {
    override fun replace(newValue: T?): Cell<T> = SouthBorderCell(this.delegate.replace(newValue))

    override fun southEast(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row + 1, col + 1, null) }

    override fun south(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row + 1, col, null) }

    override fun southWest(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row + 1, col - 1, null) }
}

data class WestBorderCell<T>(val delegate: Cell<T>) : DelegatingCell<T>(delegate) {
    override fun replace(newValue: T?): Cell<T> = WestBorderCell(this.delegate.replace(newValue))

    override fun southWest(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row + 1, col - 1, null) }

    override fun west(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row, col - 1, null) }

    override fun northWest(grid: Grid<Cell<T>>): Cell<T> = this.map { row, col, _ -> BasicCell(row - 1, col - 1, null) }
}
