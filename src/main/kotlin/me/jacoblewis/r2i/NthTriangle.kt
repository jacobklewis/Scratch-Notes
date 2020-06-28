package me.jacoblewis.r2i

fun main() {

    println(nthTriangleIter(4))
}

fun nthTriangleIter(n: Long): Long {
    if (n < 2) {
        return n
    }
    return (1..n).reduce { acc, l -> acc + l }
}


fun nthTriangle(n: Int): Int {
    if (n < 2) {
        return n
    }
    return n + nthTriangle(n - 1)
}