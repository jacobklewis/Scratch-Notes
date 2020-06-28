package me.jacoblewis.r2i

import javafx.geometry.Point2D
import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
//    println("Recursion to Iteration")
//    val sample = arrayOf(1, 2, 3, 4, 5, 6, 8, 10, 20, 35, 56)
//    println(sample.indexOf(x = 8))

    // Sorting
//    val unsorted = listOf(33, 88, 2, 71, 17, 52, 5, 87, 10, 9, 21, 40, 68, 100, 28)
//    println(mergeSort2(unsorted))

    // Is Rect
    val points = listOf(
        Point2D(161.87, 342.05),
        Point2D(246.79, 212.99),
        Point2D(403.15, 315.88),
        Point2D(318.24, 444.93)
    )
    println(isRect(points))
}


// Binary Search
fun Array<Int>.indexOf(x: Int, lower: Int = 0, upper: Int = this.size): Int {
    println("x: $x, lower: $lower, upper: $upper")
    val middleIndex = (upper + lower) / 2
    return when {
        get(middleIndex) == x -> middleIndex
        upper - lower == 1 -> -1
        x < get(middleIndex) -> indexOf(x, lower, middleIndex)
        else -> indexOf(x, middleIndex, upper)
    }
}


// Merge Sort
fun mergeSort(items: List<Int>): List<Int> {
    if (items.size <= 1) {
        return items
    }
    val midIndex = items.size / 2
    val left = mergeSort(items.subList(0, midIndex)).toMutableList()
    val right = mergeSort(items.subList(midIndex, items.size)).toMutableList()
    val sortedList = mutableListOf<Int>()
    while (left.isNotEmpty() || right.isNotEmpty()) {
        when {
            left.isEmpty() -> sortedList.add(right.removeAt(0))
            right.isEmpty() -> sortedList.add(left.removeAt(0))
            right[0] < left[0] -> sortedList.add(right.removeAt(0))
            else -> sortedList.add(left.removeAt(0))
        }
    }
    return sortedList
}

// Merge Sort Iterative
data class MergeSortComponent(val list: List<Int>, val isSorted: Boolean = false)

fun mergeSort2(items: List<Int>): List<Int> {
    if (items.size <= 1) {
        return items
    }
    val midIndex = items.size / 2
    val stack = Stack<MergeSortComponent>()
    stack.add(MergeSortComponent(items.subList(0, midIndex)))
    stack.add(MergeSortComponent(items.subList(midIndex, items.size)))
    while (stack.size > 1 || !stack[0].isSorted) {
        println(stack.map { it.list })
        val right = stack.pop()
        if (!right.isSorted && right.list.size > 1) {
            val mid = right.list.size / 2
            stack.push(MergeSortComponent(right.list.subList(0, mid)))
            stack.push(MergeSortComponent(right.list.subList(mid, right.list.size)))
            continue
        }
        // At this point, the right must be sorted
        val left = stack.pop()
        if (!left.isSorted && left.list.size > 1) {
            stack.push(MergeSortComponent(right.list, isSorted = true))
            val mid = left.list.size / 2
            stack.push(MergeSortComponent(left.list.subList(0, mid)))
            stack.push(MergeSortComponent(left.list.subList(mid, left.list.size)))
            continue
        }
        // At this point, both must be sorted
        val lList = left.list.toMutableList()
        val rList = right.list.toMutableList()
        val sortedList = mutableListOf<Int>()
        while (lList.isNotEmpty() || rList.isNotEmpty()) {
            when {
                lList.isEmpty() -> sortedList.add(rList.removeAt(0))
                rList.isEmpty() -> sortedList.add(lList.removeAt(0))
                rList[0] < lList[0] -> sortedList.add(rList.removeAt(0))
                else -> sortedList.add(lList.removeAt(0))
            }
        }
        stack.push(MergeSortComponent(sortedList, isSorted = true))

    }
    return stack[0].list
}

const val BIAS = 0.01
fun isRect(points: List<Point2D>): Boolean {
    // Rectangles must have 4 corners
    if (points.size != 4) {
        println("Not 4 points")
        return false
    }
    // Find furthest point from first point
    var maxDistIndex = 1
    val p0 = points[0]
    for (i in 1 until points.size) {
        val mp = points[maxDistIndex]
        val cp = points[i]
        if (p0.x == cp.x && p0.y == cp.y) {
            println("Points must all be distinct")
            return false
        }
        if ((p0.x - cp.x).pow(2) + (p0.y - cp.y).pow(2) > (p0.x - mp.x).pow(2) + (p0.y - mp.y).pow(2)) {
            maxDistIndex = i
        }
    }
    val p1 = points[maxDistIndex]

    val remainingPoints = points.filterIndexed { index, point2D -> index != 0 && index != maxDistIndex }
    val pb0 = remainingPoints.first()
    val pb1 = remainingPoints.last()
    // Ensure both sets of points are the same distance
    if (abs(sqrt((p0.x - p1.x).pow(2) + (p0.y - p1.y).pow(2)) - sqrt((pb0.x - pb1.x).pow(2) + (pb0.y - pb1.y).pow(2))) > BIAS) {
        println("Not the same distance")
        return false
    }
    // Ensure both sets of points have the same mid point
    if (abs((p0.x + p1.x) / 2 - (pb0.x + pb1.x) / 2) > BIAS || abs((p0.y + p1.y) / 2 - (pb0.y + pb1.y) / 2) > BIAS) {
        println("Not sharing the same midpoint")
        return false
    }

    return true
}

