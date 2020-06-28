package me.jacoblewis.r2i

fun main() {

    println(nthTriangleIter(4))
}

/**
 * @param n: A Natural Number [0-inf]
 *
 * @return The nth triangle number
 */
fun nthTriangleIter(n: Long): Long {
    return (0..n).reduce { acc, l -> acc + l }
}
fun nthTriangleIter2(n: Long): Long {
    return (0..n).sum()
}


fun nthTriangle(n: Int): Int {
    if (n < 2) {
        return n
    }
    return n + nthTriangle(n - 1)
}