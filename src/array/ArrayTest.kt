import array.DynamicArray


fun main() {
    testDynamicArray()
}

fun testDynamicArray() {
    val dynamicArray = DynamicArray<Int>()
    mutableListOf<Int>()

    println("dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    dynamicArray.add(1)

    println("After add 1, dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    dynamicArray.add(6)
    dynamicArray.add(7)

    println("After add 6,7, dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    dynamicArray.add(0, 0)
    println("After add 0 at index-0, dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    dynamicArray.remove(1)

    println("After remove 1, dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    dynamicArray.removeAt(2)

    println("After remove at index-2, dynamicArray: $dynamicArray, size: ${dynamicArray.size}")

    println("get(0): ${dynamicArray[0]}")

    val condition: (Int) -> Boolean = { element -> element > 0 && element % 2 == 0 }
    println("find(even number): ${dynamicArray.find(condition)}")
    println("find(odd number): ${dynamicArray.find { element -> element > 0 && element % 2 != 0 }}")

    println("indexOf(6): ${dynamicArray.indexOf(6)}")
    println("indexOf(9): ${dynamicArray.indexOf(9)}")

    dynamicArray.removeAt(0)
    dynamicArray.removeAt(0)
    dynamicArray.remove(0)

    println("After remove all elements: dynamicArray: $dynamicArray, size: ${dynamicArray.size}")
    println("Is array empty: ${dynamicArray.isEmpty()}")
}
