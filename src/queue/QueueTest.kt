package queue

fun main() {
    val queue = MyQueueWithArray<Int>(6)

    queue.enqueue(1)
    println("enqueue(1): $queue")
    queue.enqueue(2)
    println("enqueue(2): $queue")
    queue.enqueue(3)
    println("enqueue(3): $queue")
    queue.enqueue(4)
    println("enqueue(4): $queue")

    println("dequeue(): ${queue.dequeue()}, $queue")
    println("dequeue(): ${queue.dequeue()}, $queue")

    queue.enqueue(5)
    println("enqueue(5): $queue")

    queue.enqueue(6)
    println("enqueue(6): $queue")

    queue.enqueue(7)
    println("enqueue(7): $queue")

    println("dequeue(): ${queue.dequeue()}, $queue")

    queue.enqueue(8)
    println("enqueue(8): $queue")

    println("dequeue(): ${queue.dequeue()}, $queue")
}