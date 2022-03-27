package practice

fun main() {

}

fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
    val result = LongArray(queries.size)

    queries.forEachIndexed { i, query ->
        result[i] = find(query, intLength)
    }

    return result
}

fun find(index: Int, intLength: Int): Long {
    val position = index / 9
    val i = index % 9

    if (intLength == 1) {
        return i.toLong()
    } else if (intLength == 2) {
        return (i*10 + i).toLong()
    }

    return (position + 1)*Math.pow(10.0, (intLength-1).toDouble()).toLong() + find(index, intLength - 2) + (position + 1)
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    nums1.distinctBy {
        nums2.contains(it)
    }

    nums1.filter { nums2.contains(it).not() }
        .distinct()

    return result
}