package linkedlist.practice

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
