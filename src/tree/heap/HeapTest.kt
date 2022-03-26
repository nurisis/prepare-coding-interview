package tree.heap


fun main() {
    val maxHeap = MaxHeap()

    maxHeap.insert(3)
    println("Insert 3 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    maxHeap.insert(4)
    println("Insert 4 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    maxHeap.insert(2)
    println("Insert 2 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    maxHeap.insert(1)
    println("Insert 1 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    maxHeap.insert(6)
    println("Insert 6 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    maxHeap.insert(5)
    println("Insert 5 (size:${maxHeap.size}, max:${maxHeap.getMax()}) => $maxHeap")
    println()

    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")
    println("Extract max: ${maxHeap.extractMax()} (size:${maxHeap.size}, max:${maxHeap.getMax()}, isEmpty:${maxHeap.isEmpty()}) => $maxHeap")

    // Heapify
    val array = arrayOf(1,2,3,4,5,6,7,8,9)
    println("Before heapify: ${array.toList()}")
    // Build tree.heap (rearrange array)
    for (i in array.size / 2 - 1 downTo 0)
        MaxHeap.heapify(array, i)
    println("After heapify: ${array.toList()}")
}