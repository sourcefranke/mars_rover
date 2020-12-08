package com.github.sourcefranke.marsrover

enum class Direction(
    val forwards:   (MarsRover) -> MarsRover,
    val backwards:  (MarsRover) -> MarsRover,
    val left:       (MarsRover) -> MarsRover,
    val right:      (MarsRover) -> MarsRover
) {
    NORTH(
        forwards    = { it.copy(y = ++it.y) },
        backwards   = { it.copy(y = --it.y) },
        left        = { it.copy(direction = WEST) },
        right       = { it.copy(direction = EAST) }
    ),
    WEST(
        forwards    = { it.copy(x = --it.x) },
        backwards   = { it.copy(x = ++it.x) },
        left        = { it.copy(direction = SOUTH) },
        right       = { it.copy(direction = NORTH) }
    ),
    SOUTH(
        forwards    = { it.copy(y = --it.y) },
        backwards   = { it.copy(y = ++it.y) },
        left        = { it.copy(direction = EAST) },
        right       = { it.copy(direction = WEST) }
    ),
    EAST(
        forwards    = { it.copy(x = ++it.x) },
        backwards   = { it.copy(x = --it.x) },
        left        = { it.copy(direction = NORTH) },
        right       = { it.copy(direction = SOUTH) }
    )
}
