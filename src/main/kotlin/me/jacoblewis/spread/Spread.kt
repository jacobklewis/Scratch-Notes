package me.jacoblewis.spread


fun main() {

    val someInts = intArrayOf(4,5,7)
    println(product(*someInts))

    val someOtherInts = listOf(7,5,7)
    println(product(*someOtherInts.toIntArray()))
}


/**
 * Multiply all values together
 * @param values: The values to multiply
 *
 * @return: The product of all values
 */
fun product(vararg values: Int): Int {
    return values.reduce { acc, n -> acc * n }
}
