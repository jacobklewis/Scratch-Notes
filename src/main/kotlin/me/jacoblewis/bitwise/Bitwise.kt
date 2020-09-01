package me.jacoblewis.bitwise

fun main() {

//    introToBinary()
//    bitwiseAnd()
//    bitwiseOr()
//    bitwiseXor()
//    bitwiseInv()
//    bitwiseShl()
//    bitwiseShr()
//    bitwiseUshr()
}


fun introToBinary() {
    val num = 0b1000_1111
    println("Bin: ${num.asBin}")
    println("Dec: $num")
    println("Hex: ${num.asHex}")
}


fun bitwiseAnd() {
    val numA = 0b1010
    val numB = 0b0010
    val result = numA and numB
    println("${numA.asBin} and ${numB.asBin} == ${result.asBin}")
}


fun bitwiseOr() {
    val numA = 0b1000
    val numB = 0b0100
    val result = numA or numB
    println("${numA.asBin} or ${numB.asBin} == ${result.asBin}")
}


fun bitwiseXor() {
    val numA = 0b1001
    val numB = 0b0100
    val result = numA xor numB
    println("${numA.asBin} xor ${numB.asBin} == ${result.asBin}")
}


fun bitwiseInv() {
    val numA = 0b1000
    val invA = numA.inv()
    println(numA)
    println(invA)
}


fun bitwiseShl() {
    val numA = 0b0101
    val shlAmount = 1
    val result = numA shl shlAmount
    println("${numA.asBin} shl $shlAmount == ${result.asBin}")
}


fun bitwiseShr() {
    val numA: Int = Int.MIN_VALUE
    val shrAmount = 5
    val result = numA shr shrAmount
    println("${numA.asBin}  shr $shrAmount == ${result.asBin}")
}


fun bitwiseUshr() {
    val numA: Int = Int.MIN_VALUE
    val ushrAmount = 3
    val result = numA ushr ushrAmount
    println("${numA.asBin} ushr $ushrAmount == \n${result.asBin}")
}







