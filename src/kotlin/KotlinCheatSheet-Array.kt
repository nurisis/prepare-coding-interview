fun main() {
    array()
}

/**
 *
 */
fun array() {
    /**
     * Initialize array
     */
    val array = Array<Int>(3) { 0 }
    array[0] = 1
    array[1] = 2
    array[2] = 3
    val array2 = intArrayOf(1, 2, 3, 4)
    val array3 = IntArray(3) { 0 }

    /**
     * Converter
     */
    val toList = array.toList()
    val toMutableList = array.toMutableList()
    val toMutableSet = array.toMutableSet()
    val toSet = array.toSet()
    val toHashSet = array.toHashSet()

    /**
     * Transformer
     */
    val mapToList: List<Int> = array.map { it * it }
    val mapIndexedToList: List<Int> = array.mapIndexed { index, i -> i * i }
    val toFlatMap: List<Int> = array.flatMap { listOf(it) }
    val toSequence: Sequence<Int> = array.asSequence()
    val reversedToList: List<Int> = array.reversed()
    array.reverse()
    array.reverse(1, 3)
    array.shuffle()
    val copyToArray: Array<Int> = array.copyOf()
    val copyToArrayWithNewSize: Array<Int?> = array.copyOf(10)
    val copyOfRange: Array<Int> = array.copyOfRange(1, 2)

    /**
     * Sorting
     */
    // Sort [array]
    array.sort()
    array.sortDescending()
    array.sortBy { it }
    array.sortByDescending { it }

    // Returns a new List<Int> sorted [array]
    val sortedList = array.sorted()
    val sortedArray = array.sortedArray()
    val sortedDescendingArray = array.sortedArrayDescending()
    val sortedByList = array.sortedBy { it }
    val sortedByDescendingList = array.sortedByDescending { it }
    val sortedSet = array.toSortedSet()
    val sortedSetByComparator = array.toSortedSet { o1, o2 -> o1 + o2 }

    /**
     * Max / Min
     */
    val maxByMull = array.maxByOrNull { it*it }
    val maxOrNull = array.maxOrNull()
    val minByNull = array.minByOrNull { it*-1 }
    val minOrNull = array.minOrNull()

    /**
     * gg
     */
    val sum = array.sum()
    val sumOf = array.sumOf { it*it }

    val anyOf: Boolean = array.any { it == 1 }
    val all: Boolean = array.all { it != 1 }
    val none: Boolean = array.none { it == 1 }
}
