package me.jacoblewis.binary_communication

data class Coffee(
    val type: CoffeeType,           // 7 options                - 3 bits
    val roast: CoffeeRoast,         // 3 options                - 2 bits
    val size: Size,                 // 4 options                - 2 bits
    val milk: Milk                  // 2 options                - 1 bit
) {

    companion object {
        fun ByteArray.decode(): Coffee {
            val rawData = this[0].asInt
            val milk = Milk.values()[rawData and 0x01]
            val size = Size.values()[(rawData ushr 1) and 0x03]
            val roast = CoffeeRoast.values()[(rawData ushr 3) and 0x03]
            val type = CoffeeType.values()[(rawData ushr 5) and 0x07]
            return Coffee(type, roast, size, milk)
        }

        fun Coffee.encode(): ByteArray {
            var rawData = 0
            rawData = (rawData or type.ordinal) shl 2
            rawData = (rawData or roast.ordinal) shl 2
            rawData = (rawData or size.ordinal) shl 1
            rawData = rawData or milk.ordinal

            return byteArrayOf(rawData.toByte())
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