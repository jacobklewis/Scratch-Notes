package me.jacoblewis.bitwise

val Int.asBin: String
    get() {
        val n = this
        val minBitCount = 32 - n.countLeadingZeroBits()
        val maxBit = 3 + ((minBitCount ushr 2) shl 2)
        return (maxBit downTo 0).fold("") { acc, i ->
            acc + (if ((n ushr i) and 1 == 1) "1" else "0") + if (i % 4 == 0 && i != 0) " " else ""
        }
    }

val Int.asHex: String
    get() = toString(16)
