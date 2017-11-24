package be.edu.adventofcode.y2015.day07

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): Int {
        val instructions = input.get().map { parseInstruction(it) }.toMap().mapValues { CachingGate(it.value) }
        return instructions["a"]!!.connect { instructions[it]!! }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }

    fun parseLines(input: Lines): Map<String, Gate> = input.get().map { parseInstruction(it) }.toMap();

    private fun parseInstruction(input: String): Pair<String, Gate> = when {
        input.startsWith("NOT ") -> parseNot(input)
        input.contains(" AND ") -> parseAnd(input)
        input.contains(" OR ") -> parseOr(input)
        input.contains(" LSHIFT ") -> parseLeftShift(input)
        input.contains(" RSHIFT ") -> parseRightShift(input)
        else -> parseReference(input)
    }!!

    private fun parseReference(input: String): Pair<String, Gate>? = Regex("([a-z\\d]+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component2(), parseWire(it.component1()))
    }

    private fun parseNot(input: String): Pair<String, Gate>? = Regex("NOT ([a-z\\d]+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component2(), Not(parseWire(it.component1())))
    }

    private fun parseAnd(input: String): Pair<String, Gate>? = Regex("([a-z\\d]+) AND ([a-z\\d]+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component3(), And(parseWire(it.component1()), parseWire(it.component2())))
    }

    private fun parseOr(input: String): Pair<String, Gate>? = Regex("([a-z\\d]+) OR ([a-z\\d]+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component3(), Or(parseWire(it.component1()), parseWire(it.component2())))
    }

    private fun parseLeftShift(input: String): Pair<String, Gate>? = Regex("([a-z\\d]+) LSHIFT (\\d+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component3(), LeftShift(parseWire(it.component1()), it.component2().toInt()))
    }

    private fun parseRightShift(input: String): Pair<String, Gate>? = Regex("([a-z\\d]+) RSHIFT (\\d+) -> ([a-z]+)").matchEntire(input)?.destructured?.let {
        return Pair(it.component3(), RightShift(parseWire(it.component1()), it.component2().toInt()))
    }

    private fun parseWire(input: String): Gate = if (input.matches("\\d+".toRegex())) Constant(input.toInt()) else Lookup(input)
}

sealed class Gate {
    abstract fun connect(context: (String) -> Gate): Int
}

data class CachingGate(private val decorated: Gate) : Gate() {
    var cachedValue: Int? = null
    override fun connect(context: (String) -> Gate): Int {
        if (cachedValue == null) cachedValue = decorated.connect(context)
        return cachedValue!!
    }
}

data class Constant(private val value: Int) : Gate() {
    override fun connect(context: (String) -> Gate): Int = value
}

data class Lookup(private val wire: String) : Gate() {
    override fun connect(context: (String) -> Gate): Int = context(wire).connect(context)
}

data class And(private val first: Gate, private val second: Gate) : Gate() {
    override fun connect(context: (String) -> Gate): Int = first.connect(context) and second.connect(context)
}

data class Or(private val first: Gate, private val second: Gate) : Gate() {
    override fun connect(context: (String) -> Gate): Int = first.connect(context) or second.connect(context)
}

data class Not(private val gate: Gate) : Gate() {
    override fun connect(context: (String) -> Gate): Int = Math.pow(2.0, 16.0).toInt() + gate.connect(context).inv()
}

data class LeftShift(private val gate: Gate, private val bits: Int) : Gate() {
    override fun connect(context: (String) -> Gate): Int = gate.connect(context) shl bits
}

data class RightShift(private val gate: Gate, private val bits: Int) : Gate() {
    override fun connect(context: (String) -> Gate): Int = gate.connect(context) shr bits
}