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

    val copied = array.copyOf()
    val copiedRange = array.copyOfRange(1, 3)

    /**
     * Converter
     */
    val toList = array.toList()
    val toMutableList = array.toMutableList()
    val toMutableSet = array.toMutableSet()
    val toSet = array.toSet()
    val toHashSet = array.toHashSet()
    val toString = array.joinToString(separator = "")

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
     * Group By, Grouping By
     */
    val tempArray = arrayOf(1,1,2,2,3,3,3,3)
    // groupBy
    val grouped: Map<Int, List<Int>> = tempArray.groupBy { it }
    // groupingBy 는 Array<T> 타입에서만 사용가능하다. IntArray 에서는 groupBy 만 사용 가능
    val grouping: Grouping<Int, Int> = tempArray.groupingBy { it }

    val groupingAggregated: Map<Int, Int> = grouping.aggregate { key, accumulator, element, first ->
        (accumulator ?: 0) + element
    }
    // Reduce 는 초기값 지정없이 첫번째 원소부터 시작
    val groupingReduced: Map<Int, Int> = grouping.reduce { key, accumulator, element ->
        accumulator + element
    }
    val groupingEachCount: Map<Int, Int> = grouping.eachCount()
    // Fold 는, reduce 와 동일하나, 초기값을 지정할 수 있다. => 컬렉션이 비어있을 경우도 있기 때문에 reduce 보다는 fold 를 사용하는 것이 안전하
    val groupingFold = grouping.fold(initialValue = 10, operation = { v1, v2 ->
        v1 + v2
    })

    println("grouped: $grouped")
    println("grouping: $grouping")
    println("groupingAggregated: $groupingAggregated")
    println("groupingReduced: $groupingReduced")
    println("groupingEachCount: $groupingEachCount")
    println("groupingFold: $groupingFold")

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
     * Aggregation
     *
     * https://kotlinlang.org/docs/collection-aggregate.html
     */
    val sum = array.sum()
    val sumOf = array.sumOf { it*it }

    val anyOf: Boolean = array.any { it == 1 }
    val all: Boolean = array.all { it != 1 }
    val none: Boolean = array.none { it == 1 }

    val fold = array.fold(initial = 10, operation = { v1, v2 ->
        v1 + v2
    })
    val foldIndexed = array.foldIndexed(initial = 10, operation = { index: Int, acc: Int, i: Int ->
        if (index % 2 == 0) {
            acc - i
        } else {
            acc + i
        }
    })
}
