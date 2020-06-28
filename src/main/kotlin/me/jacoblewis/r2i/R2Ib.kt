package me.jacoblewis.r2i

import java.math.BigInteger

fun main() {

    println(fibIter(9_000_000))
}

fun factorial(n: Long): Long {
    return (1..n).reduce { acc, i -> acc * i }
}

val memo = mutableMapOf<BigInteger, BigInteger>()
fun fibRec(n: BigInteger): BigInteger {
    val result = when {
        memo.containsKey(n) -> memo[n]!!
        n <= BigInteger("0") -> BigInteger("0")
        n <= BigInteger("2") -> BigInteger("1")
        else -> fibRec(n - BigInteger("2")) + fibRec(n - BigInteger("1"))
    }
    memo[n] = result
    return result
}

fun fibIter(n: Long): BigInteger {
    return when {
        n <= 0 -> BigInteger("0")
        else -> (1..n).fold(BigInteger("0") to BigInteger("1")) { acc, _ ->
            acc.first + acc.second to acc.first
        }.first
    }
}