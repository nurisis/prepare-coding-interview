package array

/**
 * Same as [ArrayList]
 *
 * - add: O(1)
 * - add(index, value): O(n)
 * - remove: O(n)
 * - size
 * - isEmpty
 * - get: O(1)
 * - find
 * -
 */
class DynamicArray<T> {
    companion object {
        private const val CAPACITY = 10
    }

    private var array = arrayOfNulls<Any?>(CAPACITY)

    var size: Int = 0
        private set

    fun isEmpty(): Boolean = size == 0

    operator fun set(index: Int, value: T) {
        array[index] = value
    }

    operator fun get(index: Int): T {
        return if (index < size) {
            array[index] as T
        } else throw IndexOutOfBoundsException()
    }

    fun indexOf(element: T): Int {
        for (i in 0 until size) {
            if (array[i] == element) {
                return i
            }
        }

        return -1
    }

    fun add(element: T) {
        if (size == array.size) {
            resizeArray()
        }

        array[size] = element
        size++
    }

    fun add(index: Int, element: T) {
        if (size == array.size) {
            resizeArray()
        }

        for (i in size - 1 downTo index) {
            array[i + 1] = array[i]
        }
        array[index] = element
        size++
    }

    fun removeAt(index: Int): Boolean {
        if (index >= size) {
            return false
        }

        array[index] = null
        for (i in index until size - 1) {
            array[i] = array[i + 1]
        }

        size--
        return true
    }

    fun remove(element: T): Boolean {
        val index = indexOf(element)
        if (index == -1) return false

        return removeAt(index)
    }

    fun find(condition: (T) -> Boolean): T? {
        for (i in 0 until size) {
            if (condition.invoke(get(i))) {
                return get(i)
            }
        }

        return null
    }

    override fun toString(): String {
        var string = "["

        if (size > 0) {
            for (i in 0 until size - 1) {
                string += "${get(i)}, "
            }

            string += get(size - 1)
        }

        string += "]"
        return string
    }

    private fun resizeArray() {
        array = array.copyOf(size + CAPACITY)
    }
}
