package binarysearch

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6)

    require(binarySearchRecursion(6, array, 0, array.size - 1) == binarySearch(6, array))
    require(binarySearchRecursion(4, array, 0, array.size - 1) == binarySearch(4, array))
    require(binarySearchRecursion(3, array, 0, array.size - 1) == binarySearch(3, array))
    require(binarySearchRecursion(1, array, 0, array.size - 1) == binarySearch(1, array))
    require(binarySearchRecursion(0, array, 0, array.size - 1) == binarySearch(0, array))
    require(binarySearchRecursion(7, array, 0, array.size - 1) == binarySearch(7, array))
}

fun binarySearchRecursion(key: Int, array: IntArray, min: Int, max: Int): Int {
    if (min > max) return -1

    val midPoint = (min + max) / 2

    return when {
        array[midPoint] > key -> binarySearchRecursion(key, array, min, midPoint - 1)
        array[midPoint] < key -> binarySearchRecursion(key, array, midPoint + 1, max)
        else -> midPoint
    }
}

fun binarySearch(key: Int, array: IntArray): Int {
    var start = 0
    var end = array.size - 1

    while (start <= end) {
        val midPoint = (start + end) / 2

        when {
            array[midPoint] > key -> {
                end = midPoint - 1
            }
            array[midPoint] < key -> {
                start = midPoint + 1
            }
            else -> {
                return midPoint
            }
        }
    }

    return -1
}

/**
 * https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems
 */
fun binarySearchTemplate(key: Int, array: IntArray): Int {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        val mid = left + (right - left) / 2

        if (condition(array[mid], key)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

private fun condition(midKey: Int, key: Int): Boolean {
    // todo: write this condition logic depend on problems

    return midKey >= key
}