package com.github.sourcefranke.marsrover

import com.github.sourcefranke.marsrover.Direction.*

data class MarsRover (
    var direction: Direction = NORTH,
    var x: Int = 0,
    var y: Int = 0
)
