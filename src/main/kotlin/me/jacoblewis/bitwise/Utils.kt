package me.jacoblewis.bitwise

val Int.asBin: String
    get() {
        val n = this
        val maxNum = when {
            n == Int.MIN_VALUE -> 31
            (n xor 0x1) + n == 0x1 -> 0
            (n xor 0xf) + n == 0xf -> 3
            (n xor 0xff) + n == 0xff -> 7
            (n xor 0xfff) + n == 0xfff -> 11
            (n xor 0xffff) + n == 0xffff -> 15
            (n xor 0xfffff) + n == 0xfffff -> 19
            (n xor 0xffffff) + n == 0xffffff -> 23
            (n xor 0xfffffff) + n == 0xfffffff -> 27
            (n xor 0x7fffffff) + n == 0x7fffffff -> 31
            else -> 0
        }
        return (maxBit downTo 0).map { if ((n ushr it) and 1 == 1) "1" else "0" }
            .chunked(4) { it.joinToString("") }
            .joinToString(" ")
    }

val Int.asHex: String
    get() = toString(16)
