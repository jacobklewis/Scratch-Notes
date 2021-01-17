package me.jacoblewis.sealed

import kotlin.math.PI
import kotlin.math.pow


fun main() {
    val shape = Shape.Circle(3f)

    println("Shape area: ${areaOf(shape)}")
}

fun areaOf(shape: Shape): Number = when (shape) {
    is Shape.None -> 0
    is Shape.Rectangle -> shape.width * shape.height
    is Shape.Circle -> shape.radius.pow(2) * PI
}