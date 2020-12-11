package be.edu.adventofcode.calculations

class CartesianProduct {
    companion object Static {
        fun <T, U> pair(c1: Collection<T>, c2: Collection<U>): List<Pair<T, U>> =
            c1.flatMap { lhsElem -> c2.map { rhsElem -> lhsElem to rhsElem } }

        fun <T, U, V> triple(c1: Collection<T>, c2: Collection<U>, c3: Collection<V>): List<Triple<T, U, V>> =
            c1.flatMap { el1 -> c2.flatMap { el2 -> c3.map { el3 -> Triple(el1, el2, el3) } } }

        fun <T> multiple(a: Set<T>, b: Set<T>, vararg sets: Set<T>): Set<List<T>> =
            (listOf(a, b).plus(sets))
                .fold(listOf(listOf<T>())) { acc, set ->
                    acc.flatMap { list -> set.map { element -> list + element } }
                }
                .toSet()

        fun <T> repeated(input: Set<T>, times: Int): Set<List<T>> =
            listOf(input).repeat(times)
                .fold(listOf(listOf<T>())) { acc, set ->
                    acc.flatMap { list -> set.map { element -> list + element } }
                }
                .toSet()

        private fun <T> List<T>.repeat(times: Int): List<T> = (1..times).fold(listOf(), { acc, _ -> acc.plus(this) })
    }
}