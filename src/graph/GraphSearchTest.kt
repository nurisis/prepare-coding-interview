package graph

import java.util.*

fun main() {
    val graph = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0, 4),
        intArrayOf(0, 4),
        intArrayOf(0, 4),
        intArrayOf(1, 2, 3, 5),
        intArrayOf(1, 4)
    )
    print("DFS(Recursion): ")
    dfsRecursion(graph, 0, hashSetOf())
    println()

    print("DFS(Iteration): ")
    dfsIteration(graph, 0)
    println()

    print("BFS: ")
    bfs(graph, 0)
    println()

    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
}
