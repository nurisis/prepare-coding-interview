package graph

import java.util.*

/**
 * Shortest Path Faster Algorithm. (Improved Bellman-Ford algorithm)
 * https://leetcode.com/explore/featured/card/graph/622/single-source-shortest-path-algorithm/3865/
 *
 * Time complexity: O(V⋅E)
 * Space complexity: O(V)
 */

/**
 * @param adj: weighted direct graph. ex) adj[0] = [Pair(1, 100), Pair(2, 500)] 은, vertex 0 에서 vertex 1 로 weight 100 인 edge, vertex0 에서 vertex 2로 weight 500.
 * @param sourceNode : 시작 vertex
 *
 * @return [sourceNode]에서 각 vertex 까지의 최단 경로를 담은 int array.
 */
fun spfa(adj: Array<Array<Pair<Int, Int>>>, sourceNode: Int): IntArray {
    val shortest = Array(adj.size) { Int.MAX_VALUE }
    // 자기자신이니 최단 경로는 0
    shortest[sourceNode] = 0

    // 다음에 탐색할 vertex 를 담는 queue
    val queue = LinkedList<Int>()
    queue.offer(sourceNode)

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        val currentNodePath = shortest[currentNode]

        for (nextNode in adj[currentNode]) {
            val destNode = nextNode.first
            val weight = nextNode.second

            // edge relexation
            if (currentNodePath + weight < shortest[destNode]) {
                shortest[destNode] = currentNodePath + weight
                if (queue.contains(destNode).not()) {
                    queue.offer(destNode)
                }
            }
        }
    }

    return shortest.toIntArray()
}


fun main() {
    val adj = arrayOf(
        arrayOf(Pair(1,100), Pair(2,500), Pair(3,200)),
        arrayOf(Pair(2,100)),
        arrayOf(Pair(3,100)),
        arrayOf(Pair(1,-150))
    )
    println("(SPFA) Shortest path from 0 : ${spfa(adj, 0).toList()}")
}
