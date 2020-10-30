package me.jacoblewis.inline

fun main() {

    compareInts(5, 7) {
        println(it)
    }

    compareInts(5, 7) {
        println(it)
    }

}

inline fun compareInts(a: Int, b: Int, crossinline response: (String) -> Unit) {
    println("Settings up comparison")
    val task = Runnable {
        if (a < b) {
            response("a < b")
        } else if (a > b) {
            response("a > b")
        } else {
            response("a == b")
        }
    }
    task.run()
    println("Comparison finished")
}