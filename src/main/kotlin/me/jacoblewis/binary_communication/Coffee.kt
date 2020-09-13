package me.jacoblewis.binary_communication

data class Coffee(
    val type: CoffeeType,           // 7 options                - 3 bits
    val roast: CoffeeRoast,         // 3 options                - 2 bits
    val size: Size,                 // 4 options                - 2 bits
    val milk: Milk                  // 2 options                - 1 bit
) {

    // 000 00 00 0


    companion object {
        fun ByteArray.decode(): Coffee {
            val rawData = this[0].asInt
            val milk = Milk.values()[rawData and 0b1]
            val size = Size.values()[(rawData ushr 1) and 0b11]
            val roast = CoffeeRoast.values()[(rawData ushr 3) and 0b11]
            val type = CoffeeType.values()[(rawData ushr 5) and 0b111]
            return Coffee(type, roast, size, milk)
        }

        fun Coffee.encode(): ByteArray {
            var raw = 0
            raw = (raw or this.type.ordinal) shl 2 // 000x xx00
            raw = (raw or this.roast.ordinal) shl 2 // 0xxx aa00
            raw = (raw or this.size.ordinal) shl 1 // xxxa abb0
            raw = raw or this.milk.ordinal // xxxa abbc
            return byteArrayOf(raw.toByte())
        }
    }

    enum class CoffeeType {
        AMERICANO,
        CAPPUCCINO,
        DRIP,
        ESPRESSO,
        LATTE,
        COLD_BREW,
        NITRO
    }

    enum class CoffeeRoast {
        LIGHT,
        MEDIUM,
        DARK
    }

    enum class Size {
        TINY,
        MEDIUM,
        LARGE,
        EXTRA_LARGE
    }

    enum class Milk {
        NONE,
        TWO_PERCENT
    }
}