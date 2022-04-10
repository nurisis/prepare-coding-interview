package practice

/**
 * https://leetcode.com/contest/weekly-contest-287/
 * - Score: 3 / 4
 * - Rank: 5834 / 19930
 */
fun main() {
    val loserMap = hashMapOf<Int, Int>()

    val answer1 = loserMap.filter { it.value == 0 }.map { it.key }
    val answer2 = loserMap.filter { it.value == 1 }.map { it.key }
    answer1.sorted()
    answer2.sorted()

    val candies = IntArray(3){0}
    candies.sortDescending()
    candies.sumOf {
        it
    }
    val builder = StringBuilder()
    builder.append("")
    var s = ""
    val keys = CharArray(3)

    val i = "".substring(1)
    val wordSet = hashSetOf<String>(*listOf("").toTypedArray())
}

class Encrypter(keys: CharArray, values: Array<String>, dictionary: Array<String>) {

    val keys: CharArray = keys
    val values: Array<String> = values
    val dictionary: Array<String> = dictionary

    fun encrypt(word1: String): String {
        val builder = StringBuilder()

        for (i in 0 until word1.length) {
            val c = word1[i]
            val index = keys.indexOf(c)
            builder.append(values[index])
        }

        return builder.toString()
    }

    fun decrypt(word2: String): Int {

        val array = IntArray(10)
        array.reduce { acc, i -> acc*i }

        return 0
    }

}