package queue

class MyQueueWithArray<T>(
    private val size: Int
) {
    private val array = arrayOfNulls<Any?>(size)

    private var read = 0
    private var write = -1

    fun enqueue(value: T) {
        if (write < size -1) {
            write++
        } else {
            write = 0
        }

        if (array[write] != null) {
            throw Exception("No space")
            return
        }

        if (read - write == 1) {
            throw Exception("Overflow")
            return
        }

        array[write] = value
    }

    fun dequeue(): T? {
        val value = array[read]

        array[read] = null
        if (read < size - 1) {
            read++
        } else {
            read = 0
        }

        return value as? T
    }

    override fun toString(): String {
        return array.toList().toString()
    }
}
