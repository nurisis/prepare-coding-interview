package graph.practice

import java.util.*

fun main() {
    val queue: Queue<Int> = LinkedList()
    queue.offer(1)
    queue.offer(2)
    queue.offer(3)

    println(queue.poll())
}

// DFS
fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    dfs(graph, 0, Stack<Int>(), result)
    return result
}

// BFS
fun allPathsSourceTargetV2(graph: Array<IntArray>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    val queue = LinkedList<MutableList<Int>>()
    queue.offer(mutableListOf(0))

    while (queue.isNotEmpty()) {
        val path = queue.poll()
        val v = path.last()

        if (v == graph.size - 1) {
            result.add(path)
            continue
        }

        for (nextNode in graph[v]) {
            val p = path.toMutableList()
            p.add(nextNode)
            queue.offer(p)
        }
    }

    return result
}

private fun bfs(graph: Array<IntArray>, node: Int, path: Queue<Int>, paths: MutableList<List<Int>>) {
    path.offer(node)

    if (node == graph.size - 1) {
        paths.add(path.toList())
        return
    }

    for (i in graph[node]) {
        bfs(graph, i, path, paths)
    }
}

private fun dfs(graph: Array<IntArray>, node: Int, path: Stack<Int>, paths: MutableList<List<Int>>) {
    path.add(node)

    if (node == graph.size - 1) {
        paths.add(path.toList())
        return
    }

    for (i in graph[node]) {
        dfs(graph, i, path, paths)
        path.pop()
    }
}

// DFS
fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val adjacentList = Array<MutableList<Int>>(n) { mutableListOf<Int>() }
    edges.forEach {
        val a = it[0]
        val b = it[1]

        adjacentList[a].add(b)
        adjacentList[b].add(a)
    }

    val stack = Stack<Int>()
    val visited = hashSetOf<Int>()

    stack.push(source)

    while (stack.isNotEmpty()) {
        val v = stack.pop()
        if (v == destination) return true

        if (visited.contains(v)) continue

        visited.add(v)

        adjacentList[v].forEach {
            stack.add(it)
        }
    }

    return false
}

// BFS
fun validPathV2(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val adjacentList = Array<MutableList<Int>>(n) { mutableListOf() }
    edges.forEach {
        val a = it[0]
        val b = it[1]

        adjacentList[a].add(b)
        adjacentList[b].add(a)
    }

    val visited = hashSetOf<Int>()
    val queue: Queue<Int> = LinkedList()
    queue.offer(source)

    while (queue.isNotEmpty()) {
        val v = queue.poll()

        if (v == destination) return true

        if (visited.contains(v)) continue

        visited.add(v)

        for (nextNode in adjacentList[v]) {
            queue.offer(nextNode)
        }
    }

    return false
}
