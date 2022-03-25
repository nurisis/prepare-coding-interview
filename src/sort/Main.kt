package sort

fun main() {
    val array = intArrayOf(6, 5, 4, 3, 2, 1)
    MergeSort.sort(array)
    println(array.toList())

    val array2 = intArrayOf(1, 2, 3, 4, 5, 6)
    MergeSort.sort(array2)
    println(array2.toList())

    val array3 = intArrayOf(3, 5, 2, 1, 6, 4)
    MergeSort.sort(array3)
    println(array3.toList())

    val array4 = intArrayOf(6, 5, 4, 3, 2, 1)
    QuickSort.sort(array4)
    println(array4.toList())

    val array5 = intArrayOf(1, 2, 3, 4, 5, 6)
    MergeSort.sort(array5)
    println(array5.toList())

    val array6 = intArrayOf(3, 5, 2, 1, 6, 4)
    MergeSort.sort(array6)
    println(array6.toList())

    val array7 = intArrayOf(3)
    MergeSort.sort(array7)
    println(array7.toList())
}
