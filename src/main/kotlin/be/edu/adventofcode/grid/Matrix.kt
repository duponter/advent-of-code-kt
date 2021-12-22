package be.edu.adventofcode.grid

typealias Matrix<T> = List<List<T>>

fun <T> Matrix<T>.transpose(): Matrix<T> {
    return (0 until this[0].size).map { x ->
        (this.indices).map { y ->
            this[y][x]
        }
    }
}
