package me.jacoblewis.calculus

import kotlin.math.cos
import kotlin.math.sin


fun main() {
    println("f1: ${f1(7.0)}")
    println("f1': ${f1p(7.0)}")
    println("~f1': ${f1.dx(7.0)}")
}

val f1 = { x: Double -> x * x }

val f1p = { x: Double -> 2 * x }


const val DIFF = 0.0000001
fun ((Double)->Double).dx(x: Double): Double {
    // Calculates the derivative at the point `x`
    return (this(x + DIFF) - this(x)) / DIFF
}