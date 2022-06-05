import java.lang.StringBuilder
import java.util.*

fun main() {
    string()

    val token = StringTokenizer("ab,c,d", ",")
    while (token.hasMoreTokens()) {
        println("TOken: ${token.nextToken()}")
    }
}

fun string() {
    val string = "string"
    /**
     * String to Digit
     */
    // int 등 type 범위 체크하기 유용
    string.toIntOrNull()
    string.toLongOrNull()
    string.toDoubleOrNull()
    string.toFloatOrNull()

    /**
     * Character
     */
    val char = '0'

    // check if char is digit
    '0'.isDigit()
    val isDigit: Boolean = char in '0'..'9'

    // Get int from character
    val charToInt: Int = '6' - '0' // 6
    val charCode: Int = char.code // or char.toInt()
    println("$charToInt,  $charCode")

    /**
     * Etc
     */
    // trim
    val trimmed = string.trim()
    string.trimEnd()
    string.trimStart()

    // split
    val splitted = string.split(" ", ",")

    // StringTokenizer -> 이건 split 와 다르게 [delim] 파라미터로 넣은애들 기준으로 모두 split 해주고 해당 문자를 포함안시킴. 즉, 여러 문자로 split 하기에는 이게 최적임.
    val tokenizer = StringTokenizer(string, " ,.!")
    while (tokenizer.hasMoreTokens()) {
        val token = tokenizer.nextToken()
    }
    val count = tokenizer.countTokens()

    /**
     * StringBuilder
     */
    var stringBuilder = StringBuilder()
    stringBuilder.append('a')
    stringBuilder.append(1)
    // delete => removeRange 는 builder 내 string 자체를 remove 하는게 아님.
    stringBuilder.deleteCharAt(0)
    stringBuilder.delete(0,3)
    // insert => append(text, start, end) 는 builder 내 string 자체를 insert 하는게 아님.
    stringBuilder.insert(2, "abc")

    /**
     * Comparison
     */
    // 문자열 비교에서는 24가 더 큼.
    val shouldTrue = "123" < "24"
}


