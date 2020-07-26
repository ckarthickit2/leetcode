package com.ckarthickit.tree

import java.util.*
import kotlin.collections.ArrayList


class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun arrayToTree(arr: Array<Int?>): TreeNode? {
    return arrayToTree(arr, 0)
}

private fun arrayToTree(arr: Array<Int?>, index: Int): TreeNode? {
    val root: TreeNode? = if (index < arr.size) arr[index]?.let { TreeNode(it) } else null
    root?.left = arrayToTree(arr, leftChildIndexOf(index))
    root?.right = arrayToTree(arr, rightChildIndexOf(index))
    return root
}

fun leftChildIndexOf(index: Int): Int {
    return 2 * index + 1
}

fun rightChildIndexOf(index: Int): Int {
    return 2 * index + 2
}

fun leetArrayToTree(arr: ArrayList<Int?>): TreeNode? {
    val root: TreeNode? = arr.removeAt(0)?.let { TreeNode(it) }
    if (root == null) {
        return root
    }
    val queue = LinkedList<TreeNode>()
    queue.push(root)
    leetArrayToTree(arr, queue)
    return root
}

fun leetArrayToTree(arr: ArrayList<Int?>, queue: Queue<TreeNode>) {
    while (queue.isNotEmpty()) {
        val root = queue.poll()
        val leftVal = if (arr.isNotEmpty()) arr.removeAt(0) else null
        val rightVal = if (arr.isNotEmpty()) arr.removeAt(0) else null
        root?.left = leftVal?.let { TreeNode(it) }
        root?.right = rightVal?.let { TreeNode(it) }
        if (root?.left != null) {
            queue.offer(root.left)
        }
        if (root.right != null) {
            queue.offer(root.right)
        }
    }
}