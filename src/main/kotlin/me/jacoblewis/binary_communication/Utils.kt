package me.jacoblewis.binary_communication

val ByteArray.asHex: String
    get() = joinToString(" ") { b -> b.toUByte().toInt().toString(16).let { if (it.length == 1) "0${it}" else it } }

val ByteArray.asBinary: String
    get() = joinToString(" ") { b ->
        val raw = b.toUByte().toInt()
        val u = (raw ushr 4).takeIf { it > 0 }?.toString(2)?.let {
            "${"0".repeat(4 - it.length)}$it "
        } ?: ""
        val l = (raw and 0xf).toString(2).let {
            "${"0".repeat(4 - it.length)}$it"
        }
        "$u$l"
    }