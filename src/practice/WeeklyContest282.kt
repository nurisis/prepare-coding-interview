package practice

import kotlin.math.max
import kotlin.math.min


/**
 * https://leetcode.com/contest/weekly-contest-282/
 */
fun main() {
    println("minSteps(s = \"aab\", t = \"abc\"): ${minSteps3(s = "aab", t = "abc")}")
    println("minSteps(s = \"leetcode\", t = \"coats\"): ${minSteps3(s = "leetcode", t = "coats")}")
    println("minSteps(s = \"night\", t = \"thing\"): ${minSteps3(s = "night", t = "thing")}")

    println("minimunTime: ${minimumTime(intArrayOf(10000),10000000)}")
    println("minimumTime: ${minimumTime(intArrayOf(39,82,69,37,78,14,93,36,66,61,13,58,57,12,70,14,67,75,91,1,34,68,73,50,13,40,81,21,79,12,35,18,71,43,5,50,37,16,15,6,61,7,87,43,27,62,95,45,82,100,15,74,33,95,38,88,91,47,22,82,51,19,10,24,87,38,5,91,10,36,56,86,48,92,10,26,63,2,50,88,9,83,20,42,59,55,8,15,48,25), totalTrips = 4187)}")
}

/**
 * You are given an array of strings words and a string pref.
 * Return the number of strings in words that contain pref as a prefix.
 */
fun prefixCount(words: Array<String>, pref: String): Int {
    var count = 0

    words.forEach {
        if (it.startsWith(pref)) count++
    }

    return count
}

/**
 * 2186. Minimum Number of Steps to Make Two Strings Anagram II
 * You are given two strings s and t. In one step, you can append any character to either s or t.
 * Return the minimum number of steps to make s and t anagrams of each other.
 * An anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 * [link](https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/)
 */
// Other good solution. Runtime: 639 ms / Memory Usage: 89.2 MB
fun minSteps3(s: String, t: String): Int {
    val array = Array('z' - 'a' + 1) { 0 }

    s.forEach {
        array[it - 'a']++
    }
    t.forEach {
        array[it - 'a']--
    }

    return array.reduce { acc, i -> Math.abs(acc) + Math.abs(i) }
}
// Runtime: 656 ms / Memory Usage: 70.1 MB
fun minSteps2(s: String, t: String): Int {
    var total = 0

    for (char in 'a'..'z') {
        total += Math.max(s.count { it == char }, t.count { it == char })
    }

    return (total - s.length) + (total - t.length)
}

// Runtime: 813 ms / Memory Usage: 87.9 MB
fun minSteps(s: String, t: String): Int {
    var total = 0
    val hashmapS = hashMapOf<Char, Int>()
    val hashmapT = hashMapOf<Char, Int>()

    s.forEach {
        hashmapS[it] = hashmapS.getOrDefault(it, 0) + 1
    }
    t.forEach {
        hashmapT[it] = hashmapT.getOrDefault(it, 0) + 1
    }

    for (char in 'a'..'z') {
        total += Math.max(hashmapS.getOrDefault(char, 0), hashmapT.getOrDefault(char, 0))
    }

    return (total - s.length) + (total - t.length)
}

// 시간 초과 난 풀이
fun minStepsTimeExceed(s: String, t: String): Int {
    var tStep = s
    t.forEach {
        tStep = tStep.replaceFirst("[$it]".toRegex(),"")
    }

    var sStep = t
    s.forEach {
        sStep = sStep.replaceFirst("[$it]".toRegex(),"")
    }

    return tStep.length + sStep.length
}

/**
 * 2187. Minimum Time to Complete Trips
 * [link](https://leetcode.com/problems/minimum-time-to-complete-trips/)
 */
// Using binary search
fun minimumTime(time: IntArray, totalTrips: Int): Long {
    var left = 1L
    var right = 1e14.toLong()

    while (left < right) {
        var mid = (left + right) / 2

        val midValue = time.sumFuc { (mid / it) }
        if (midValue < totalTrips) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return left
}

private fun IntArray.sumFuc(func: (Long) -> Long): Long {
    var result = 0L

    forEach {
        result += func(it.toLong())
    }

    return result
}

// 시간 초과로 실패한 풀이
fun minimumTimeTimeExceeded(time: IntArray, totalTrips: Int): Long {
    var count = 1L
    while (true) {
        if (time.any { count % it == 0L }) {
            val sum = time.sumBy { (count / it).toInt() }
            if (sum >= totalTrips) return count
        }

        count++
    }
}

/**
 * 2188. Minimum Time to Finish the Race
 * https://leetcode.com/problems/minimum-time-to-finish-the-race/
 *
 * solution: https://leetcode.com/problems/minimum-time-to-finish-the-race/discuss/1802444/C%2B%2B-Linear-time-DP-with-explanation
 */
fun minimumFinishTime(tires: Array<IntArray>, changeTime: Int, numLaps: Int): Int {
    var count = 0


    return count
}