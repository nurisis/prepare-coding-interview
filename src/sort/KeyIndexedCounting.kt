package sort

/**
 * Sort an array [array] of N integers between 0 and [R]-1
 *
 * https://www.coursera.org/learn/algorithms-part2/lecture/2pi1Z/key-indexed-counting
 */
fun keyIndexedSort(array: IntArray, R: Int) {
    val size = array.size
    val countArray = IntArray(R + 1)

    for (i in 0 until size) {
        countArray[array[i] + 1]++
    }

    for (i in 0 until R) {
        countArray[i + 1] += countArray[i]
    }

    val aux = IntArray(size)
    for (i in 0 until size) {
        aux[countArray[array[i]]++] = array[i]
    }

    for (i in 0 until size) {
        array[i] = aux[i]
    }
}
