package algorithm

import kotlin.math.pow

fun main() {
    require(findString("GEEKS-FOR-GEEKS", "GEEKS") contentEquals intArrayOf(0, 10))
    require(findString("CatDogHotDog-CarrotDog2", "Dog") contentEquals intArrayOf(3, 9, 19))
    require(findString("안녕누리야키키나는누리란다누리야하", "누리야") contentEquals intArrayOf(2, 13))
}

/**
 * @return IntArray contains starting index of the strings corresponding to [pattern] in [string]
 */

private const val WHATEVER_NUMBER_YOU_WANT = 7.0

fun findString(string: String, pattern: String): IntArray {
    val list = mutableListOf<Int>()

    val lengthOfString = string.length
    val lengthOfPattern = pattern.length

    val hashCodeOfPattern = hash(pattern, lengthOfPattern)

    var hashCodeOfStringToSearch = 0
    for (i in 0..(lengthOfString - lengthOfPattern)) {
        val word = string.substring(IntRange(i, i + lengthOfPattern - 1))

        hashCodeOfStringToSearch = if (i == 0) {
            hash(word, lengthOfPattern)
        } else {
            /**
             * hash(word) = d(hash(previousWord) - previousWord[0]*d^(lengthOfPattern-1)) + word[last index of word]
             */
            val firstCharOfPreviousWord: Int = string[i - 1].code
            (WHATEVER_NUMBER_YOU_WANT * (hashCodeOfStringToSearch - firstCharOfPreviousWord * WHATEVER_NUMBER_YOU_WANT.pow(lengthOfPattern - 1))).toInt() +
                    string[i + lengthOfPattern - 1].code
        }

        if (hashCodeOfStringToSearch == hashCodeOfPattern) {
            // If the hash code is the same, check whether the actual string is the same
            if (pattern == word) {
                list.add(i)
            }
        }
    }

    return list.toIntArray()
}

/**
 * hash(s) = d*(s[0]^(lengthOfPattern-1)) + d*(s[1]^(lengthOfPattern-2)) + ... + d*(s[n-1]^(lengthOfPattern-n-2))
 * Here, d == [WHATEVER_NUMBER_YOU_WANT], so just number you want.
 */
private fun hash(s: String, lengthOfPattern: Int): Int {
    var hashCode = 0

    s.forEachIndexed { index, c ->
        hashCode += c.code * WHATEVER_NUMBER_YOU_WANT.pow(lengthOfPattern - index - 1).toInt()
    }

    return hashCode
}
