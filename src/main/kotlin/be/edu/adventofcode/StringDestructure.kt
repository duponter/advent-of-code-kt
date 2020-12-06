package be.edu.adventofcode


class StringDestructure(val regex: Regex) {
    constructor(pattern: String): this(Regex(pattern))

    fun singleOrNull(input: CharSequence): String? = destructure(input)?.component1()

    fun single(input: CharSequence): String = singleOrNull(input) ?: throw noMatch(input)

    fun pairOrNull(input: CharSequence): Pair<String, String>? = destructure(input)?.let { it.component1() to it.component2() }

    fun pair(input: CharSequence): Pair<String, String> = pairOrNull(input) ?: throw noMatch(input)

    fun tripleOrNull(input: CharSequence): Triple<String, String, String>? = destructure(input)?.let { Triple(it.component1(), it.component2(), it.component3()) }

    fun triple(input: CharSequence): Triple<String, String, String> = tripleOrNull(input) ?: throw noMatch(input)

    fun many(input: CharSequence): List<String> = destructure(input)?.toList() ?: listOf()

    fun all(input: CharSequence): List<String> = matchEntire(input)?.groupValues ?: listOf()

    private fun matchEntire(input: CharSequence): MatchResult? = this.regex.matchEntire(input)

    private fun destructure(input: CharSequence): MatchResult.Destructured? = matchEntire(input)?.destructured

    private fun noMatch(input: CharSequence) = IllegalArgumentException("Input $input does not match $regex")
}