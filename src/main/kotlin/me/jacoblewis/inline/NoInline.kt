package me.jacoblewis.inline

fun main() {

    compareInts2(98, 34, { a, b -> a * b % 2 == 0 }) {
        println(it)
    }

}

inline fun compareInts2(a: Int, b: Int, customCompare: (Int, Int) -> Boolean, noinline response: (String) -> Unit) {
    println("Settings up comparison")
    if (customCompare(a, b)) {
        superSecretFunction(a, b, response)
    }
    println("Comparison finished")
}

fun superSecretFunction(a: Int, b: Int, response: (String) -> Unit) {
    if (a < b) {
        response("a < b")
    } else if (a > b) {
        response("a > b")
    } else {
        response("a == b")
    }
}