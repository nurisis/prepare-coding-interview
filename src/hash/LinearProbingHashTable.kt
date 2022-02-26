package hash

class LinearProbingHashTable<T, R>(
    capacity: Int
) {

    enum class KEY {
        /**
         * Key state after value deleted.
         * Why not just use null and create a separate [NONE] state like this?
         * -> Just deleting it can cause problems in search(get() function)
         */
        NONE
    }
    private var arrayKeys = arrayOfNulls<Any?>(capacity)
    private var arrayValues = arrayOfNulls<Any?>(capacity)
    // size of hash table
    private var tableSize = capacity
    private var currentSize = 0

    /**
     * @param m: size of hash table
     */
    private fun hash(key: T): Int {
        return key.hashCode() % tableSize
    }

    fun size(): Int = currentSize

    /**
     * Keep probing until an empty slot is found. (key == null or key == KEY.NONE)
     * Once an empty slot is found, insert [key] and [value].
     */
    fun add(key: T, value: R) {
        val hash = hash(key)

        var index = hash
        var count = 1
        var keyCandidate = arrayKeys[index]
        while (keyCandidate != null && keyCandidate != KEY.NONE && keyCandidate != key) {
            if (count > tableSize) {
                throw Exception("Can't add ($key, $value), Slots are full !!!")
            }

            index = (hash + count++) % tableSize
            keyCandidate = arrayKeys[index]
        }

        arrayKeys[index] = key
        arrayValues[index] = value

        currentSize++
    }

    fun exists(key: T): Boolean {
        return get(key) != null
    }

    /**
     * Keep probing until slot’s key doesn’t become equal to [key] or an empty slot is reached(key == null).
     */
    fun get(key: T): R? {
        val hash = hash(key)

        var index = hash
        var keyCandidate = arrayKeys[index]
        var count = 1
        while (keyCandidate != key && keyCandidate != null) {
            if (count > tableSize) return null

            index = (hash + count++) % tableSize
            keyCandidate = arrayKeys[index]
        }

        return arrayValues[index] as? R
    }

    fun remove(key: T): Boolean {
        val hash = hash(key)

        var index = hash
        var possibleKey = arrayKeys[index]
        var count = 1
        while (possibleKey != key && possibleKey != null) {
            if (count > tableSize) return false

            index = (hash + count++) % tableSize
            possibleKey = arrayKeys[index]
        }

        if (possibleKey == key) {
            arrayKeys[index] = KEY.NONE
            arrayValues[index] = null

            return true
        }

        return false
    }

    override fun toString(): String {
        var result = "["
        for (i in arrayKeys.indices) {
            result += "(${arrayKeys[i]}, ${arrayValues[i]})"

            if (i < arrayKeys.size - 1) {
                result += ", "
            }
        }

        result += "]"
        return result
    }
}
