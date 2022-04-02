package graph

import java.util.*

fun dijkstra(adj: Array<Array<Pair<Int, Int>>>, sourceNode: Int): IntArray {
    val shortest = Array(adj.size) { Int.MAX_VALUE }
    shortest[sourceNode] = 0

    // Pair(node, nodeTime)
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.offer(Pair(sourceNode, 0))

    shortest[sourceNode] = 0

    while (queue.isNotEmpty()) {
        val pair = queue.poll()

        val currentNode = pair.first
        val currentPath = pair.second

        for (nextNode in adj[currentNode]) {
            val dest = nextNode.first
            val weight = nextNode.second

            if (currentPath + weight < shortest[dest]) {
                shortest[dest] = currentPath + weight
                queue.offer(Pair(dest, shortest[dest]))
            }
        }
    }

    return shortest.toIntArray()
}

fun main() {
    val adj = arrayOf(
        arrayOf(Pair(1,100), Pair(2,500)),
        arrayOf(Pair(2,100)),
        arrayOf(),
    )
    println("(Dijkstra) Shortest path from 0 : ${dijkstra(adj, 0).toList()}")
}
