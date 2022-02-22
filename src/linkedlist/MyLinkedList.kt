package linkedlist

class Node<T>(
    var value: T
) {
    var next: Node<T>? = null
}

class MyLinkedList<T> constructor(
    value: T
) {
    var head: Node<T>? = Node(value)

    var size = 1
        private set

    fun isEmpty(): Boolean = size == 0

    private fun getNode(index: Int): Node<T>? {
        if (index >= size || index < 0) return null

        var node = head
        for (i in 0 until index) {
            node = node?.next
        }

        return node
    }

    fun get(index: Int): T? {
        return getNode(index)?.value
    }

    fun pushFront(element: T) {
        val node = Node(element)
        node.next = head
        head = node

        size++
    }

    fun popFront(): T? {
        if (size <= 0) return null

        val front = head

        head = front?.next

        size--
        return front?.value
    }

    fun pushBack(element: T) {
        val tailNode = getNode(size - 1)
        tailNode?.next = Node(element)

        size++
    }

    fun popBack(): T? {
        if (size <= 0) return null

        var beforeTailNode = getNode(size - 2)

        var tailNode: Node<T>?
        // node 가 1개 일 때
        if (beforeTailNode == null) {
            tailNode = head
            head = null
        } else {
            tailNode = beforeTailNode?.next
            beforeTailNode?.next = null
        }

        size--
        return tailNode?.value
    }

    fun front(): T? {
        return head?.value
    }

    fun back(): T? {
        return get(size - 1)
    }

    fun insert(index: Int, element: T) {
        if (index > size || index < 0) return

        val newNode = Node(element)
        val oldNodeLeft = getNode(index - 1)
        val oldNodeRight = getNode(index)

        if (oldNodeLeft == null) {
            head = newNode
        } else {
            oldNodeLeft.next = newNode
        }

        newNode?.next = oldNodeRight
        size++
    }

    fun remove(index: Int) {
        val nodeToRemove: Node<T>? = getNode(index) ?: return

        val nodeToRemoveLeft = getNode(index - 1)

        if (nodeToRemoveLeft == null) {
            head = nodeToRemove?.next
        } else {
            nodeToRemoveLeft.next = nodeToRemove?.next
        }

        size--
    }

    override fun toString(): String {
        var string = "["

        var node = head
        while (node?.next != null) {
            string += "${node?.value}, "
            node = node?.next
        }

        if (node != null)
            string += "${node?.value}"

        string += "]"
        return string
    }
}
