import java.lang.StringBuilder

fun main() {
    string()
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

    /**
     * StringBuilder
     */
    var sub = StringBuilder()
    sub.append('a')
    sub.append(1)

    /**
     * Comparison
     */
    // 문자열 비교에서는 24가 더 큼.
    val shouldTrue = "123" < "24"
}

