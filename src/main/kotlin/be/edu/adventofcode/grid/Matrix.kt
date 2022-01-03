package be.edu.adventofcode.grid

typealias Matrix<T> = List<List<T>>

fun <T> Matrix<T>.transpose(): Matrix<T> {
    return (0 until this[0].size).map { x ->
        (this.indices).map { y ->
            this[y][x]
        }
    }
}

fun <T, R> Matrix<T>.map(transform: (T) -> R): Matrix<R> {
    return this.map { row: List<T> -> row.map { transform(it) } }
}

fun <T, R> Matrix<T>.mapIndexed(transform: (row: Int, col: Int, T) -> R): Matrix<R> {
    return this.mapIndexed { rowIdx, row -> row.mapIndexed { colIdx, value -> transform(rowIdx, colIdx, value) } }
}

fun <T> Matrix<T>.size(): Int {
    return if (this.isEmpty()) 0 else this.size * this[0].size
}

fun <T> Matrix<T>.print(): String {
    return this.joinToString("\n")
}
