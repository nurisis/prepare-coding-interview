fun main() {


    val list = mutableListOf(listOf(1))

    println(3 % 5)

    val collections = hashMapOf<Int, MutableList<Int>>().filter {
        it.value.size > 1
    }.values

    var max = 0
    collections.forEach { list ->
        for (i in 0 until list.size - 1) {
            val temp = Math.abs(list[i] - list[i+1])
            if (temp > max) {
                max = temp
            }
        }
    }
}

fun isBigger(string1:String, string2: String): Boolean {
    when {
        string1.length > string2.length -> return true
        string1.length < string2.length -> return false
        else -> {
            var index = 0
            while (index < string1.length) {
                if (string1[index] < string2[index]) return false
                index++
            }
        }
    }

    return true
}