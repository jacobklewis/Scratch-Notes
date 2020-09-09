package me.jacoblewis.binary_communication

import java.nio.ByteBuffer
import java.nio.ByteOrder

data class Coffee(
    val type: CoffeeType,           // 7 options                - 3 bits
    val roast: CoffeeRoast,         // 3 options                - 2 bits
    val size: Size,                 // 4 options                - 2 bits
    val milk: Milk,                 // 8 options                - 3 bits
    val sugarAmountTeaSpoons: Int   // Teaspoons of sugar: 0..3 - 2 bits
) {
    init {
        if (sugarAmountTeaSpoons !in 0..3) {
            throw Exception("Sugar Amount (Tea Spoons) must be in range: 0-3")
        }
    }

    companion object {
        fun ByteArray.decode(): Coffee {
            val buffer = ByteBuffer.allocate(4)
            buffer.put(this)
            val rawData = buffer.getInt(0) ushr 16
            val sugarAmountTeaSpoons = rawData and 0x03 // 0011
            val milk = Milk.values()[(rawData ushr 2) and 0x07]
            val size = Size.values()[(rawData ushr 5) and 0x03]
            val roast = CoffeeRoast.values()[(rawData ushr 7) and 0x03]
            val type = CoffeeType.values()[(rawData ushr 9) and 0x07]
            return Coffee(type, roast, size, milk, sugarAmountTeaSpoons)
        }

        fun Coffee.encode(): ByteArray {
            var rawData = 0
            rawData = (rawData or type.ordinal) shl 2
            rawData = (rawData or roast.ordinal) shl 2
            rawData = (rawData or size.ordinal) shl 3
            rawData = (rawData or milk.ordinal) shl 2
            rawData = (rawData or (sugarAmountTeaSpoons and 0x03))

            val buffer = ByteBuffer.allocate(4)
            buffer.putInt(rawData)
            return buffer.array().copyOfRange(2, 4)
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
        TWO_PERCENT,
        WHOLE,
        NON_FAT,
        COCONUT,
        ALMOND,
        SOY,
        HALF_N_HALF
    }
}