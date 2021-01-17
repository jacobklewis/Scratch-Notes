package me.jacoblewis.sealed

sealed class Shape {
    object None : Shape()
    sealed class Rectangle(val width: Float, val height: Float) : Shape()
    data class Circle(val radius: Float) : Shape()
}