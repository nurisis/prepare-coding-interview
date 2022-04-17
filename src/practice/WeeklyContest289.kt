package practice

fun main() {
    var temp = "1"
    val group = temp.chunked(3)
    println("group: $group")
    val by = temp.groupBy {
        it
    }

    val adj = hashMapOf<Int, MutableList<Int>>()
    intArrayOf().mapIndexed { index, i ->
        (index to i)
    }
        .filter {
            it.first != 0
        }
        .groupBy {
            it.second
        }
        .map {
            adj[it.key] = it.value.map { it.first }.toMutableList()

            it.value.forEach { values ->
                if (adj[values.first] == null) adj[values.first] = mutableListOf()
                adj[values.first]!!.add(it.key)
            }
        }

    adj.forEach { t, u ->
        u.forEach { value ->

        }
    }

    temp = group.map {
        it.sumOf { char -> char - '0' }.toString()
    }
        .also { println("after: $it") }
        .joinToString("")

    println("temp: $temp")
}
