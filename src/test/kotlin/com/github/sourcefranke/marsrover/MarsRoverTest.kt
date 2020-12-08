package com.github.sourcefranke.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverTest : ShouldSpec({
    context("Initialize") {
        val rover = MarsRover()

        rover.direction shouldBe Direction.NORTH
        rover.x shouldBe 0
        rover.y shouldBe 0
    }

    context("Move") {
        should("forwards") {
            val rover = move(MarsRover(), "f")

            rover.direction shouldBe Direction.NORTH
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("backwards") {
            val rover = move(MarsRover(), "b")

            rover.direction shouldBe Direction.NORTH
            rover.x shouldBe 0
            rover.y shouldBe -1
        }
        should("left") {
            val rover = move(MarsRover(), "l")

            rover.direction shouldBe Direction.WEST
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right") {
            val rover = move(MarsRover(), "r")

            rover.direction shouldBe Direction.EAST
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right and forward") {
            val rover = move(MarsRover(), "rf")

            rover.direction shouldBe Direction.EAST
            rover.x shouldBe 1
            rover.y shouldBe 0
        }
        should("forward and right") {
            val rover = move(MarsRover(), "fr")

            rover.direction shouldBe Direction.EAST
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("running wild") {
            val rover = move(MarsRover(), "blfrfflb")

            rover.direction shouldBe Direction.WEST
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("dance left") {
            val rover = move(MarsRover(), "l")
            val rover2 = move(MarsRover(), "rrr")

            rover.direction shouldBe rover2.direction
        }
        should("dance right") {
            val rover = move(MarsRover(), "lll")
            val rover2 = move(MarsRover(), "r")

            rover.direction shouldBe rover2.direction
        }
    }
})
