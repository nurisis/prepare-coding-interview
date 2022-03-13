package practice

import heap.MaxHeap
import java.util.*

fun main() {
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    heap.offer(1)
    heap.offer(2)
    heap.offer(3)
    println(heap.poll())
    println("heap: $heap")
}

fun maximumTop(nums: IntArray, k: Int): Int {
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    var mutableList = nums.toMutableList()

    for (i in 1 until k) {
        when {
            mutableList.isNotEmpty() -> {
                val removed = mutableList.removeAt(0)
                heap.add(removed)
            }
            heap.isNotEmpty() -> {
                mutableList.add(0, heap.poll())
            }
            else -> {
                return -1
            }
        }

    }

    if (heap.isEmpty() && mutableList.size < 2) {
        return -1
    } else {
        return Math.max(heap.peek() ?: -1, mutableList.getOrNull(0) ?: -1)
    }
}

//fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
//    nums.mapIndexed { index, i ->
//        Pair(index, i)
//    }.filter {
//        it.second == key
//    }.map {
//        it.first
//    }
//
//    val keyList = nums.filter {
//        it == key
//    }.mapIndexed { index, i ->
//        index
//    }
//
//    nums.forEach { num ->
//        keyList.find { Math.abs(num - it) <= k }
//    }
//}