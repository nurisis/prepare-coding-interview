package heap

import array.DynamicArray

class MaxHeap {
    private val array = DynamicArray<Int>()

    init {
        // To save from index 1
        array.add(-1)
    }

    val size: Int
        get() = array.size - 1

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun insert(value: Int) {
        // 1. insert at the end
        array.add(value)

        // 2. sort with parent node
        shiftUp(size)
    }

    /**
     * Returns the max item, removing it
     */
    fun getMax(): Int? {
        return if (size > 0) array[1] else null
    }

    /**
     * Returns the max item, removing it
     */
    fun extractMax(): Int? {
        if (size == 0) return null

        val root = array[1]

        // set last node to root position
        val lastIndex = size
        array[1] = array[lastIndex]
        array.removeAt(lastIndex)

        // sort with child node
        shiftDown(1)

        return root
    }

    // For insert
    private fun shiftUp(childIndex: Int) {
        var newNodeIndex = childIndex
        var parentIndex = newNodeIndex / 2
        while (parentIndex > 0 && array[newNodeIndex] > array[parentIndex]) {
            val temp = array[newNodeIndex]
            array[newNodeIndex] = array[parentIndex]
            array[parentIndex] = temp

            newNodeIndex = parentIndex
            parentIndex = newNodeIndex / 2
        }
    }

    // For extract_max
    private fun shiftDown(parentIndex: Int) {
        var parentIndex = parentIndex
        var leftChildIndex = parentIndex * 2
        var rightChildIndex = parentIndex * 2 + 1
        while (parentIndex <= size && leftChildIndex <= size && rightChildIndex <= size
            && (array[parentIndex] < array[leftChildIndex] || array[parentIndex] < array[rightChildIndex])) {
            if (array[leftChildIndex] < array[rightChildIndex]) {
                val temp = array[parentIndex]
                array[parentIndex] = array[rightChildIndex]
                array[rightChildIndex] = temp

                parentIndex = rightChildIndex
                rightChildIndex = parentIndex * 2 + 1
            } else {
                val temp = array[parentIndex]
                array[parentIndex] = array[leftChildIndex]
                array[leftChildIndex] = temp

                parentIndex = leftChildIndex
                leftChildIndex = parentIndex * 2
            }
        }
    }

    override fun toString(): String {
        return array.toString()
    }

}
