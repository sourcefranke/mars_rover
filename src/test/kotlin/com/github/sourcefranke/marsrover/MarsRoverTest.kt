package com.github.sourcefranke.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

import com.github.sourcefranke.marsrover.Direction.*

class MarsRoverTest : ShouldSpec({
    context("Initialize") {
        val rover = MarsRover()

        rover.direction shouldBe NORTH
        rover.x shouldBe 0
        rover.y shouldBe 0
    }

    context("Move") {
        should("forwards") {
            val rover = doMove(MarsRover(), "f")

            rover.direction shouldBe NORTH
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("backwards") {
            val rover = doMove(MarsRover(), "b")

            rover.direction shouldBe NORTH
            rover.x shouldBe 0
            rover.y shouldBe -1
        }
        should("left") {
            val rover = doMove(MarsRover(), "l")

            rover.direction shouldBe WEST
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right") {
            val rover = doMove(MarsRover(), "r")

            rover.direction shouldBe EAST
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right and forward") {
            val rover = doMove(MarsRover(), "rf")

            rover.direction shouldBe EAST
            rover.x shouldBe 1
            rover.y shouldBe 0
        }
        should("forward and right") {
            val rover = doMove(MarsRover(), "fr")

            rover.direction shouldBe EAST
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("running wild") {
            val rover = doMove(MarsRover(), "blfrfflb")

            rover.direction shouldBe WEST
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("dance left") {
            val rover = doMove(MarsRover(), "l")
            val rover2 = doMove(MarsRover(), "rrr")

            rover.direction shouldBe rover2.direction
        }
        should("dance right") {
            val rover = doMove(MarsRover(), "lll")
            val rover2 = doMove(MarsRover(), "r")

            rover.direction shouldBe rover2.direction
        }
    }
})
