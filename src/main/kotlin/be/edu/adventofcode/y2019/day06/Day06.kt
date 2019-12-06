package be.edu.adventofcode.y2019.day06

import be.edu.adventofcode.Lines

class Day06 {
    fun part1(input: Lines): Int {
        val orbitMap = input.get()
                .map { it.split(')') }
                .groupBy( { it.first() }, { it.last() } )

        return listOrbits(orbitMap, SpaceObject("COM")).values
                .map { it.orbitCount() }
                .sum()
    }

    private fun listOrbits(orbitMap: Map<String, List<String>>, spaceObject: SpaceObject): Map<String, SpaceObject> {
        val tmp = mutableMapOf<String, SpaceObject>()
        tmp[spaceObject.name] = spaceObject
        orbitMap.getOrElse(spaceObject.name, { listOf() })
                .map { listOrbits(orbitMap, SpaceObject(it, spaceObject)) }
                .forEach { tmp.putAll(it) }
        return tmp
    }

    fun part2(input: Lines): Int {
        val orbitMap = input.get()
                .map { it.split(')') }
                .groupBy( { it.first() }, { it.last() } )

        val orbits: Map<String, SpaceObject> = listOrbits(orbitMap, SpaceObject("COM"))

        val you = orbits.getValue("YOU").orbits()
        val santa = orbits.getValue("SAN").orbits()

        return you.minus(santa).count() + santa.minus(you).count() - 2
    }
}

class SpaceObject(val name: String, private val orbitAround: SpaceObject? = null) {
    fun orbitCount(): Int = if (orbitAround == null) 0 else orbitAround.orbitCount() + 1

    fun orbits(): List<SpaceObject> = if (orbitAround == null) listOf(this) else listOf(this).plus(orbitAround.orbits())
}

