package kotlin

fun main() {
    hashMap()
}

fun hashMap() {
    val hashMap = hashMapOf<Int, Int>()

    val getMaxByValue: Map.Entry<Int, Int>? = hashMap.maxByOrNull { it.value }
    val toPair = getMaxByValue?.toPair()
}