package binarysearch.practice

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * [link](https://leetcode.com/problems/sqrtx)
 */
fun mySqrt(x: Int): Int {
    var left = 0L
    var right = x.toLong() + 1

    while (left < right) {
        var mid = (left + right) / 2

        // mid^2 > x
        if (mid * mid > x) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    // `left` is the minimum k value, `k - 1` is the answer
    return left.toInt() - 1
}

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * https://leetcode.com/problems/search-insert-position/
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size

    while (left < right) {
        var pivot = left + (right - left) / 2

        //  looking for the minimal k value satisfying nums[k] >= target
        if (nums[pivot] >= target) {
            right = pivot
        } else {
            left = pivot + 1
        }
    }

    return left
}