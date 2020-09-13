package me.jacoblewis.binary_communication

import me.jacoblewis.binary_communication.Coffee.Companion.decode
import me.jacoblewis.binary_communication.Coffee.Companion.encode

fun main() {

    val coffee = Coffee(
        Coffee.CoffeeType.LATTE,
        Coffee.CoffeeRoast.DARK,
        Coffee.Size.TINY,
        Coffee.Milk.TWO_PERCENT
    )
    val encodedCoffee = coffee.encode()

    println("Original Coffee: $coffee")
    println("------------------------->")

    println("Encoded values:")
    println("HEX: ${encodedCoffee.asHex}")
    println("BIN: ${encodedCoffee.asBinary}")
    println("------------------------->")

    println("Decoded Coffee: ${encodedCoffee.decode()}")
}