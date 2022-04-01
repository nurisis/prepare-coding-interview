package graph

import java.util.*
import kotlin.collections.HashSet

fun dfsRecursion(graph:Array<IntArray>, node: Int, visited: HashSet<Int>) {
    if (visited.contains(node)) return

    visited.add(node)
    print("$node, ")

    for (nextNode in graph[node]) {
        if (visited.contains(nextNode).not()) {
            dfsRecursion(graph, nextNode, visited)
        }
    }
}

fun dfsIteration(graph:Array<IntArray>, node: Int) {
    val visited = hashSetOf<Int>()
    val stack = Stack<Int>()
    stack.push(node)

    while (stack.isNotEmpty()) {
        val v = stack.pop()
        if (visited.contains(v)) continue

        visited.add(v)
        print("$v, ")

        for (nextNode in graph[v]) {
            if (visited.contains(nextNode).not()) {
                stack.push(nextNode)
            }
        }
    }
}
