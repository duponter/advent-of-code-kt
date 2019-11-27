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

import be.edu.adventofcode.Lines

class Day${day} {
    fun part1(input: Lines): Int {
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}
EOL
}

cat_test() {
	year=$1
	day=$2
	cat >src/test/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}Spec.kt <<EOL
package be.edu.adventofcode.y${year}.day${day}

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object Day${day}Spec : Spek({
    describe("day ${day}") {
        val day${day} = Day${day}()
        context("part 1") {
            it("testcase") {
                assertEquals(1, day${day}.part1(LinesFromArray("line")))
            }
            it("should answer Part1") {
                assertEquals(0, day${day}.part1(DayInput().lines(day${day})))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(1, day${day}.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day${day}.part2(DayInput().lines(day${day})))
            }
        }
    }
})
EOL
}

year=$1
for arg in "${@:2}"
do
	day=$(printf "%02d" ${arg})

	echo "Generating ${day} of ${year}"

	touch_file src/main/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}.kt
	touch_file src/main/resources/be/edu/adventofcode/y${year}/day${day}/Day${day}.txt
	touch_file src/test/kotlin/be/edu/adventofcode/y${year}/day${day}/Day${day}Spec.kt

	cat_main ${year} ${day}
	cat_test ${year} ${day}
done
