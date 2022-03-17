package sort

fun main() {
    val array = intArrayOf(6,5,4,3,2,1)
    MergeSort.sort(array)
    println(array.toList())

    val array2 = intArrayOf(1,2,3,4,5,6)
    MergeSort.sort(array2)
    println(array2.toList())

    val array3 = intArrayOf(3,5,2,1,6,4)
    MergeSort.sort(array3)
    println(array3.toList())
}