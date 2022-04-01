package graph

import java.util.*


fun bfs(graph:Array<IntArray>, node: Int) {
    val visited = hashSetOf<Int>()
    val queue = LinkedList<Int>()
    queue.offer(node)

    while (queue.isNotEmpty()) {
        val v = queue.poll()
        if (visited.contains(v)) continue

        print("$v, ")
        visited.add(v)

        for (nextNode in graph[v]) {
            if (visited.contains(nextNode).not()) {
                queue.offer(nextNode)
            }
        }
    }
}
