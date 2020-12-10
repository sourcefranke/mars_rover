package com.github.sourcefranke.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverTest : ShouldSpec({
    context("Initialize") {
        val rover = MarsRover()

        rover.direction::class shouldBe North()::class
        rover.x shouldBe 0
        rover.y shouldBe 0
    }

    context("Move") {
        should("forwards") {
            val rover = doMove(MarsRover(), "f")

            rover.direction::class shouldBe North()::class
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("backwards") {
            val rover = doMove(MarsRover(), "b")

            rover.direction::class shouldBe North()::class
            rover.x shouldBe 0
            rover.y shouldBe -1
        }
        should("left") {
            val rover = doMove(MarsRover(), "l")

            rover.direction::class shouldBe West()::class
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right") {
            val rover = doMove(MarsRover(), "r")

            rover.direction::class shouldBe East()::class
            rover.x shouldBe 0
            rover.y shouldBe 0
        }
        should("right and forward") {
            val rover = doMove(MarsRover(), "rf")

            rover.direction::class shouldBe East()::class
            rover.x shouldBe 1
            rover.y shouldBe 0
        }
        should("forward and right") {
            val rover = doMove(MarsRover(), "fr")

            rover.direction::class shouldBe East()::class
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("running wild") {
            val rover = doMove(MarsRover(), "blfrfflb")

            rover.direction::class shouldBe West()::class
            rover.x shouldBe 0
            rover.y shouldBe 1
        }
        should("dance left") {
            val rover = doMove(MarsRover(), "l")
            val rover2 = doMove(MarsRover(), "rrr")

            rover.direction::class shouldBe rover2.direction::class
        }
        should("dance right") {
            val rover = doMove(MarsRover(), "lll")
            val rover2 = doMove(MarsRover(), "r")

            rover.direction::class shouldBe rover2.direction::class
        }
    }
})
