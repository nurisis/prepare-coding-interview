package linkedlist.practice

import java.util.*

fun main() {
    val node = ListNode(1)
    node.next = ListNode(2)
    node.next!!.next = ListNode(2)
    node.next!!.next!!.next = ListNode(1)

    println("isPalindrome: ${isPalindrome2(node)}")
}

fun isPalindrome2(head: ListNode?): Boolean {
    val list = mutableListOf<Int>()

    val map = TreeMap<Int, Int>()
    map.forEach {  }

    var temp = head
    while (temp != null) {
        list.add(temp.`val`)
        temp = temp.next
    }

    val size = list.size
    for (i in 0 until size/2) {
        if (list[i] != list[size - i - 1]) return false
    }

    return true
}

val stack = LinkedList<Int>()

fun isPalindrome(head: ListNode?): Boolean {
    val reverseNode = reverse(head)
    var temp = reverseNode

    while (temp != null) {
        if (temp?.`val` != stack.pop().also { println("val: ${temp?.`val`}, pop:$it") }) return false
        temp = temp?.next
    }

    return true
}

private fun reverse(head: ListNode?): ListNode? {
    println("head >> ${head?.`val`}")
    if (head != null) {
        stack.add(head.`val`)
    }
    if(head?.next == null) {
        return head
    }

    val node = reverse(head?.next)
    head.next!!.next = head
    head.next = null
    println("after >> stack : $stack / node: $node")
    return node
}

/**
 * Problem: Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5] => Output: [5,4,3,2,1]
 * Input: head = [] => Output: []
 *
 * [link](https://leetcode.com/problems/reverse-linked-list/)
 */

/**
 * Solution1 - Recursive
 */
fun reverseListRecursionVersion(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val p = reverseListRecursionVersion(head.next)
    head.next!!.next = head
    head.next = null
    return p
}

/**
 * Solution2 - Iterative
 */
fun reverseListIterativeVersion(head: ListNode?): ListNode? {
    var old = head
    var new: ListNode? = null

    while (old != null) {
        val node = old
        old = old.next

        node.next = new
        new = node
    }

    return new
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var result = ""

        var temp: ListNode? = this
        while (temp != null) {
            result += "${temp.`val`}(${temp.hashCode()}) -> "
            temp = temp.next
        }

        return result
    }
}
