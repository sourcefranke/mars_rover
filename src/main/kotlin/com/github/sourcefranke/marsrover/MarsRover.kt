package com.github.sourcefranke.marsrover

/**
 * Represents the Mars rover to be navigated
 *
 * @param direction the [Direction] the rover is currently looking to
 * @param x the x coordinate the rover is currently placed
 * @param y the y coordinate the rover is currently placed
 */
data class MarsRover (
    var direction: Direction = North(),
    var x: Int = 0,
    var y: Int = 0
)

/**
 * Executes the movement order for a given Mars rover
 *
 * @param rover the [MarsRover] object to be moved
 * @param order a set of multiple steps to be done by the rover object
 * @return a new instance of [MarsRover] with updated position data
 */
fun doMove (rover: MarsRover, order: String): MarsRover {
    if(order.isEmpty()) return rover

    return doMove(
        rover.let( mapStepToMoveFunc(rover.direction, order[0]) ),
        order.substring(1)
    )
}

/**
 * Maps a single step to the correct [Move] function needed
 * Allowed steps for moving the rover around are:
 * - 'f' for moving forwards
 * - 'b' for moving backwards
 * - 'l' for turning left
 * - 'r' for turning right
 *
 * For any other given character nothing will happen - the rover instance will be returned unchanged
 *
 * @param direction the current [Direction] the next step is related to
 * @param step the very next single step to be executed out of the order chain
 * @return the correct [Move] function mapped to the given [Direction] and [step]
 */
fun mapStepToMoveFunc (direction: Direction, step: Char): Move {
    return when (step) {
        'f' -> direction.forwards
        'b' -> direction.backwards
        'l' -> direction.left
        'r' -> direction.right
        else -> { it -> it }
    }
}

typealias Move = (MarsRover) -> MarsRover

/**
 * Sum type for possible directions a [MarsRover] can look to
 *
 * @param forwards [Move] function for moving forwards
 * @param backwards [Move] function for moving backwards
 * @param left [Move] function for turning left
 * @param right [Move] function for turning right
 */
sealed class Direction (
    val forwards:   Move,
    val backwards:  Move,
    val left:       Move,
    val right:      Move
)

class North: Direction (
    forwards    = { it.copy(y = it.y + 1) },
    backwards   = { it.copy(y = it.y - 1) },
    left        = { it.copy(direction = West()) },
    right       = { it.copy(direction = East()) }
)

class West: Direction (
    forwards    = { it.copy(x = it.x - 1) },
    backwards   = { it.copy(x = it.x + 1) },
    left        = { it.copy(direction = South()) },
    right       = { it.copy(direction = North()) }
)

class South: Direction (
    forwards    = { it.copy(y = it.y - 1) },
    backwards   = { it.copy(y = it.y + 1) },
    left        = { it.copy(direction = East()) },
    right       = { it.copy(direction = West()) }
)

class East: Direction (
    forwards    = { it.copy(x = it.x + 1) },
    backwards   = { it.copy(x = it.x - 1) },
    left        = { it.copy(direction = North()) },
    right       = { it.copy(direction = South()) }
)
