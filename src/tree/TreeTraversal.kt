package tree

import java.util.*

/**
 * Recursive way
 */
private val levels = mutableListOf<MutableList<Int>>()
fun helper(root: TreeNode, level: Int) {
    if (levels.size == level) {
        levels.add(mutableListOf())
    }

    levels[level].add(root.`val`)

    root.left?.let { helper(it, level+1) }
    root.right?.let { helper(it, level+1) }
}

fun levelOrderWay2(root: TreeNode?): List<List<Int>> {
    if (root != null) {
        helper(root, 0)
    }

    return levels.toList()
}

/**
 * Iteration way
 */
fun levelOrderWay1(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val result = mutableListOf<List<Int>>()

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val nodes = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            nodes.add(queue.poll())
        }

        result.add(nodes.map { node ->
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }

            node.`val`
        })
    }

    return result.toList()
}
