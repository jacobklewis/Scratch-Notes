package me.jacoblewis.inline

fun main() {
    val list = listOf(1,2,3,4,5)

    list.forEveryOther {
        println(it)
    }
}

inline fun Collection<Int>.forEveryOther(block: (e:Int)->Unit) {
    for ((i, item) in withIndex()) {
        if (i % 2 == 0) {
            block(item)
        }
    }
}
