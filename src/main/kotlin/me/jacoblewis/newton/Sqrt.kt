package me.jacoblewis.newton

//import me.jacoblewis.calculus.dx
import kotlin.math.abs
import kotlin.math.roundToLong


fun main() {
    val a = 100.0

    val f = { x: Double -> x * x - a }

//    val result = a.converge { x ->
////        x - (f(x) / f.dx(x))
//    }

//    println("Final: $result")
}

inline fun Double.converge(
    bias: Double = 0.000000001,
    operation: (x0: Double) -> Double
): Double {
    var x = this
    var xOld = -this + 1
    while (abs(x - xOld) > bias) {
        xOld = x
        x = operation(x)
        println(x)
    }
    return (x / bias).roundToLong() * bias
}


