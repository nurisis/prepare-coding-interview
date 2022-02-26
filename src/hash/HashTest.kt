package hash

fun main() {
    val numOfArray = 10
    val listOfPair = hashMapOf<Int, Char>()
    val linearProbingHashTable = LinearProbingHashTable<Int, Char>(numOfArray)
    // Allocate key value to array
    for (i in 0 until numOfArray) {
        val key = 5*i
        val value = ('A'.code + i).toChar()
        listOfPair[key] = value
        linearProbingHashTable.add(key, value)
    }
    println("Put every key value pair: $linearProbingHashTable")

    for (i in 0 until 11) {
        val key = 5*i
        val value = linearProbingHashTable.get(key)

        require(value == listOfPair[key])
    }

    linearProbingHashTable.remove(35)
    listOfPair.remove(35)
    println("Remove 35 : $linearProbingHashTable")

    for (i in 0 until 11) {
        val key = 5*i
        val value = linearProbingHashTable.get(key)

        require(value == listOfPair[key])
    }

    linearProbingHashTable.add(50, 'K')
    listOfPair[50] = 'K'
    println("Put (50, 'K') : $linearProbingHashTable")
}