package com.github.sourcefranke.marsrover

fun move(rover: MarsRover, order: String): MarsRover {
    if(order.isEmpty()) return rover

    return move(
        rover.let(
            action(
                rover.direction,
                order[0]
            )
        ),
        order.substring(1)
    )
}

val action = { dir: Direction, step: Char ->
    when (step) {
        'f' -> dir.forwards
        'b' -> dir.backwards
        'l' -> dir.left
        'r' -> dir.right
        else -> { throw Exception() }
    }
}
