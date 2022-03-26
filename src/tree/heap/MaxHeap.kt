package tree.heap

import array.DynamicArray

class MaxHeap {
    private val array = DynamicArray<Int>()

    init {
        // To save from index 1
        array.add(-1)
    }

    companion object {
        /**
         * To heapify a subtree rooted with node [index] which is an index in [array].
         */
        fun heapify(array: Array<Int>, index: Int) {
            if (index >= array.size) return

            var parent = index
            val left = parent*2 + 1
            val right = parent*2 + 2

            val childIndex = when {
                left < array.size && right < array.size -> {
                    if (array[left] > array[right]) left
                    else if (array[left] < array[right]) right
                    else return
                }
                left < array.size -> {
                    left
                }
                else -> {
                    return
                }
            }

            if (array[parent] < array[childIndex]) {
                val temp = array[parent]
                array[parent] =  array[childIndex]
                array[childIndex] = temp

                parent = childIndex
            }

            heapify(array, parent)
        }
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

    // todo@nurisis: should implement remove function
    fun remove(index: Int) {
        if (index >= array.size) return

        // if leaf node
        if (index*2 >= array.size/2) {
            array.removeAt(index)
        }
        else {
            val leftIndex = index*2
            val rightIndex = index*2 + 1
            when {
                leftIndex < array.size && rightIndex < array.size -> {
                    if (array[leftIndex] < array[rightIndex]) {
                        array[index] = array[rightIndex]
                        array.removeAt(rightIndex)
                    } else {
                        array[index] = array[leftIndex]
                        array[leftIndex] = array[rightIndex]
                        array.removeAt(rightIndex)
                    }
                }
                leftIndex < array.size -> {
                    array[index] = array[leftIndex]
                    array.removeAt(leftIndex)
                }
            }
        }
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
