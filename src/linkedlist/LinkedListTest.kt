package linkedlist

fun main() {
    val linkedList = MyLinkedList(2)

    println("After initialized: $linkedList, size: ${linkedList.size}")
    linkedList.pushBack(3)
    println("After pushBack(3): $linkedList, size: ${linkedList.size}")
    linkedList.pushBack(4)
    println("After pushBack(4): $linkedList, size: ${linkedList.size}")
    linkedList.pushBack(5)
    println("After pushBack(5): $linkedList, size: ${linkedList.size}")
    linkedList.pushBack(6)
    println("After pushBack(6): $linkedList, size: ${linkedList.size}")

    linkedList.pushFront(1)
    println("After pushFront(1): $linkedList, size: ${linkedList.size}")
    linkedList.pushFront(0)
    println("After pushFront(0): $linkedList, size: ${linkedList.size}")

    println("popBack(): ${linkedList.popBack()}, $linkedList, size: ${linkedList.size}")
    println("popFront(): ${linkedList.popFront()}, $linkedList, size: ${linkedList.size}")

    println("get(3): ${linkedList.get(3)}, size: ${linkedList.size}")
    println("get(10): ${linkedList.get(10)}, size: ${linkedList.size}")
    println("front(): ${linkedList.front()}, size: ${linkedList.size}")
    println("back(): ${linkedList.back()}, size: ${linkedList.size}")
    println("isEmpty(): ${ linkedList.isEmpty()}, size: ${linkedList.size}")

    linkedList.popBack()
    linkedList.popBack()
    linkedList.popBack()
    linkedList.popBack()
    linkedList.popBack()
    linkedList.popBack()

    println("After popBack 6 times, isEmpty(): ${linkedList.isEmpty()}, $linkedList")
}
