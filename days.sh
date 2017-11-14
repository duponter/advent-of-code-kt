#!/usr/bin/env bash

touch_file() {
	mkdir -p "$(dirname "$1")" || exit
	touch $1
}

cat_main() {
	year=$1
	day=$2
	cat >src/main/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}.kt <<EOL
package be.edu.adventofcode.y${year}.day${day}

import be.edu.adventofcode.DayInput

class Day${day} {
    fun part1(): Int {
        return DayInput().lines(this).count()
    }

	fun part2(): Int {
        return DayInput().lines(this).count()
    }
}
EOL
}

cat_test() {
	year=$1
	day=$2
	cat >src/test/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}Spec.kt <<EOL
package be.edu.adventofcode.y${year}.day${day}

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object Day${day}Spec : Spek({
    given("day ${day}") {
        val day${day} = Day${day}();
        on("part 1") {
            val answer = day${day}.part1()
            it("should answer Part1") {
                assertEquals(0, answer)
            }
        }
        on("part 2") {
            val answer = day${day}.part2()
            it("should answer Part2") {
                assertEquals(0, answer)
            }
        }
    }
})
EOL
}

for arg in "$@"
do
    year='2015'
	day=$(printf "%02d" ${arg})

	touch_file src/main/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}.kt
	touch_file src/main/resources/be/edu/adventofcode/y${year}/day${day}/Day${day}.txt
	touch_file src/test/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}Spec.kt

	cat_main ${year} ${day}
	cat_test ${year} ${day}
done
