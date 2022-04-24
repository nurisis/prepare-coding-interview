import java.util.*

fun main() {
    stack()
    queue()
}

fun stack() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    // pop 과 동일한 값을 반환하지만, 실제로 스택에서 제거하지는 않음.
    println(stack.peek())

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}

fun queue() {
    val queue: Queue<Int> = LinkedList()

    queue.offer(1)
    queue.offer(2)
    queue.offer(3)

    // poll 과 동일한 값을 반환하지만, 실제로 큐에서 제거하지는 않음.
    println(queue.peek())

    println(queue.poll())
    println(queue.poll())
    println(queue.poll())
}
