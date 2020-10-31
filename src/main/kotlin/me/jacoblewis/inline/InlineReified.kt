package me.jacoblewis.inline

import java.util.*

fun main() {
    "Hello".printType()
    12.printType()
    11.0.printType()
    Date().printType()
}

inline fun <reified T> T.printType() {
    println("Type: ${T::class.java.simpleName}")
}