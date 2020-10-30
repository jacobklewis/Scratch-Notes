package me.jacoblewis.inline

fun main() {
    val mug = drinkCoffee(12, 10, actions = {
        it.drinkCoffee(5)
        it.fillWithCoffee(9)
        it.drinkCoffee(1)
        it.fillWithCoffee(5)
    }, onError = {
        println("There was an error: ${it.message}")
    })

    println("Final amount filled: ${mug.amountFilled}")
}


inline fun drinkCoffee(
    mugSize: Int,
    initialHeight: Int,
    actions: (CoffeeMug) -> Unit,
    onError: (e: Exception) -> Unit
): CoffeeMug {
    val mug = CoffeeMug(mugSize)
    mug.fillWithCoffee(initialHeight)
    try {
        actions(mug)
    } catch (e: Exception) {
        onError(e)
    }
    return mug
}