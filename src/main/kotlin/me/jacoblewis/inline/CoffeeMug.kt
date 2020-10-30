package me.jacoblewis.inline

import kotlin.math.max

class CoffeeMug(val size: Int) {
    var amountFilled: Int = 0

    fun fillWithCoffee(amount: Int) {
        println("Filling with $amount oz of Coffee")
        amountFilled += amount
        if (amountFilled > size) {
            amountFilled = size
            throw Exception("Coffee Overflowed!!! Oh no!")
        }
    }

    fun drinkCoffee(amount: Int) {
        println("Drinking $amount oz of Coffee")
        amountFilled = max(amountFilled - amount, 0)
        if (amountFilled > size) {
            throw Exception("Coffee Overflowed!!! Oh no!")
        }
    }
}