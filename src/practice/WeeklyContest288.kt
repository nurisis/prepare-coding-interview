import kotlin.math.pow

/**
 * https://leetcode.com/contest/weekly-contest-288/
 * - Score: 1 / 4
 */
fun main() {
    largestInteger(100)
}

fun largestInteger(num: Int): Int {
    var string = num.toString()
    var array = string.toCharArray().map { it.toString().toInt() }.toTypedArray()

    var max = -1
    var maxIndex = -1
    array.forEachIndexed { index, i ->
        if (i > max) {
            max = i
            maxIndex = index
        }
    }
    var first = -1
    var firstIndex = -1
    for (i in array.indices) {
        if (array[i] % 2 == max % 2) {
            first = array[i]
            firstIndex = i

            break
        }
    }
    array[firstIndex] = max
    array[maxIndex] = first

    var max2 = -1
    var maxIndex2 = -1
    array.forEachIndexed { index, i ->
        if (i > max2 && i != max) {
            max2 = i
            maxIndex2 = index
        }
    }
    var second = -1
    var secondIndex = -1
    for (i in array.indices) {
        if (array[i] % 2 == max2 % 2 && array[i] != max) {
            second = array[i]
            secondIndex = i

            break
        }
    }

    val array2 = mutableListOf<IntArray>()
    val num = array2.minByOrNull {
        val a = it[0]
        val b = it[0]
        val c = it[0]
        val d = it[0]

        a*(b+c)*d
    }

    for (i in 10 downTo 0) {

    }

    return 0
}
