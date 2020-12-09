package be.edu.adventofcode.calculations

class CartesianProduct {
    companion object Static {
        fun <T, U> pair(c1: Collection<T>, c2: Collection<U>): List<Pair<T, U>> {
            return c1.flatMap { lhsElem -> c2.map { rhsElem -> lhsElem to rhsElem } }
        }

        fun <T, U, V> triple(c1: Collection<T>, c2: Collection<U>, c3: Collection<V>): List<Triple<T, U, V>> {
            return c1.flatMap { el1 -> c2.flatMap { el2 -> c3.map { el3 -> Triple(el1, el2, el3) } } }
        }
    }
}