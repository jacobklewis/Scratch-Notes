package me.jacoblewis.binary_communication

import me.jacoblewis.binary_communication.Coffee.Companion.decode
import me.jacoblewis.binary_communication.Coffee.Companion.encode

fun main() {

    val coffee = Coffee(Coffee.CoffeeType.COLD_BREW, Coffee.CoffeeRoast.MEDIUM, Coffee.Size.LARGE, Coffee.Milk.NON_FAT, 3)
    val encodedCoffee = coffee.encode()
    println(encodedCoffee.asHex)
    println(encodedCoffee.asBinary)

    println(encodedCoffee.decode())
    println("Binary Communication")
}