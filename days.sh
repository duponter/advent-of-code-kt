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
import be.edu.adventofcode.LinesFromArray

class Day${day} {
    fun part1(input: Lines): Int {
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

fun main() {
    val testInput = LinesFromArray(

    )
    println("Day ${day}, part 1 = \${Day${day}().part1(testInput)}")
//    println("Day ${day}, part 2 = \${Day${day}().part2(testInput)}")
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
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day${day}Spec : DescribeSpec({
    describe("day ${day}") {
        val day${day} = Day${day}()
        val testInput = LinesFromArray(

        )
        context("part 1") {
            it("Part 1 - Testcase - ") {
                day${day}.part1(testInput) shouldBe 1
            }
            xit("Part 1 - Solution - ") {
                day${day}.part1(DayInput().lines(day${day})) shouldBe 0
            }
        }
        xcontext("part 2") {
            it("Part 2 - Testcase - ") {
                day${day}.part2(testInput) shouldBe 1
            }
            xit("Part 2 - Solution - ") {
                day${day}.part2(DayInput().lines(day${day})) shouldBe 0
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
