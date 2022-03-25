package sort

object QuickSort {
    fun sort(array: IntArray) {
        quickSort(array, 0, array.size - 1)
    }

    private fun quickSort(array: IntArray, left: Int, right: Int) {
        if (left == right) return

        var i = left
        var j = right

        val count = right - left
        val pivotMod = (left..right).random() % count
        val pivot = array[left + pivotMod]

        while (i <= j) {
            while (array[i] < pivot) i++
            while (array[j] > pivot) j--

            if (i <= j) {
                swap(array, i++, j--)
            }
        }

        if (left < j) {
            quickSort(array, left, j)
        }

        if (i < right) {
            quickSort(array, i, right)
        }
    }

    private fun swap(array: IntArray, start: Int, end: Int) {
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp
    }
}

