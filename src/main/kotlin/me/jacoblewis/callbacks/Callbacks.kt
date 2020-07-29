package me.jacoblewis.callbacks

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


fun main() {
    val fred = Barista("Fred")
    val sam = Barista("Sam")

    fred.acceptOrder(CoffeeType.LATTE)
    sam.acceptOrder(CoffeeType.AMERICANO)
}

class Barista(val name: String) {
    private val coffeeMaker = CoffeeMaker()

    fun acceptOrder(type: CoffeeType) {
        coffeeMaker.brewCoffee(type) {
            println("$name finished brewing ${this.type}")
        }
    }
}


enum class CoffeeRoast {
    LIGHT,
    MEDIUM,
    DARK
}

data class Coffee(val type: CoffeeType)
class CoffeeMaker {
    fun brewCoffee(type: CoffeeType, onBrewed: Coffee.() -> Unit) {
        delay(type.brewTime) { // Simulates time to make coffee (ASYNC)
            val madeCoffee = Coffee(type)
            onBrewed(madeCoffee)
        }
    }
}

enum class CoffeeType(val brewTime: Long) {
    AMERICANO(300L),
    CAPPUCCINO(950L),
    DRIP(100L),
    ESPRESSO(800L),
    LATTE(875L)
}

fun delay(time: Long) {
    Thread.sleep(time)
}

fun delay(time: Long, complete: () -> Unit) {
    val completableFuture = CompletableFuture<String>()
    Executors.newCachedThreadPool().submit<Any?> {
        Thread.sleep(time)
        completableFuture.complete("")
        null
    }
    completableFuture.thenAccept { complete() }
}