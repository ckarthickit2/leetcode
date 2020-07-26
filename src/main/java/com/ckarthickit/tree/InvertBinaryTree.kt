package com.ckarthickit.tree

import java.util.*

/**
 * Invert a binary tree.
 *
 * Example:
 * ========
 *
 *	Input:
 *
 *	     4
 *	   /   \
 *	  2     7
 *	 / \   / \
 *	1   3 6   9
 *
 *	Output:
 *
 *	     4
 *	   /   \
 *	  7     2
 *	 / \   / \
 *	9   6 3   1
 *
 *
 */


fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val leftRet = invertTree(root.left)
    val rightRet = invertTree(root.right)
    root.left = rightRet
    root.right = leftRet
    return root
}

fun main() {
    val root = TreeNode(4).also { r ->
        r.left = TreeNode(2).also { l1 ->
            l1.left = TreeNode(1)
            l1.right = TreeNode(3)
        }
        r.right = TreeNode(7).also { l1 ->
            l1.left = TreeNode(6)
            l1.right = TreeNode(9)
        }
    }
    invertTree(root)
    levelOrderTraverse(root)
}

private val levelMarkerNode = TreeNode(Int.MAX_VALUE)
private val nullMarkerNode = TreeNode(Int.MIN_VALUE)
private fun levelOrderTraverse(tree: TreeNode?) {
    val queue = LinkedList<TreeNode?>()
    queue.addFirst(tree)
    queue.addFirst(levelMarkerNode)
    while (!queue.isEmpty()) {
        val curNode = requireNotNull(queue.removeLast())
        if (curNode === levelMarkerNode) {
            println("")
            continue
        } else if (curNode == nullMarkerNode) {
            print("null\t")
            continue
        } else {
            print("${curNode.`val`}\t")
        }
        if (curNode.left != null) {
            queue.addFirst(curNode.left)
        } else {
            queue.addFirst(nullMarkerNode)
        }
        if (curNode.right != null) {
            queue.addFirst(curNode.right)
        } else {
            queue.addFirst(nullMarkerNode)
        }
        queue.addFirst(levelMarkerNode) //marker for a level end
    }
}