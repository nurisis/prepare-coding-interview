package algorithm


/**
 * KMP:
 * String pattern matching algorithm.
 *
 * https://www.youtube.com/watch?v=yWWbLrV4PZ8
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * Ex. https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 */

fun main() {
    println("kmp(\"abcdeabc\", \"abc\"): ${kmp("abcdeabc", "abc").toList()}")
}

fun getPi(pattern: String): IntArray {
    val size = pattern.length
    val piArray = IntArray(size)

    var j = 0
    for (i in 1 until size) {
        while (j > 0 && pattern[j] != pattern[i]) {
            j = piArray[j - 1]
        }

        if (pattern[j] == pattern[i]) {
            piArray[i] = ++j
        }
    }

    return piArray
}

fun kmp(string: String, pattern: String): IntArray {
    val stringSize = string.length
    val patternSize = pattern.length

    val matchingArray = mutableListOf<Int>()
    val piArray = getPi(pattern)

    var j = 0
    for (i in 0 until stringSize) {
        while (j > 0 && pattern[j] != string[i]) {
            j = piArray[j - 1]
        }

        if (pattern[j] == string[i]) {
            if (j == patternSize - 1) {
                matchingArray.add(i - patternSize + 1)

                j = piArray[j]
            } else j++
        }
    }

    return matchingArray.toIntArray()
}