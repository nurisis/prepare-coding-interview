package sort


object MergeSort {
    fun sort(array: IntArray) {
        mergeSort(array, 0, array.size - 1)
    }

    private fun mergeSort(array: IntArray, start: Int, end: Int) {
        if (start < end) {
            val mid = start + (end - start) / 2
            mergeSort(array, start, mid)
            mergeSort(array, mid + 1, end)
            merge(array, start, mid, end)
        }
    }

    private fun merge(array: IntArray, start: Int, mid: Int, end: Int) {
        val temp = IntArray(array.size)
        var i = start
        var j = mid + 1

        var index = start
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++]
            } else {
                temp[index++] = array[j++]
            }
        }

        while (i <= mid) {
            temp[index++] = array[i++]
        }

        while (j <= end) {
            temp[index++] = array[j++]
        }

        for (i in start..end) {
            array[i] = temp[i]
        }
    }
}
