package com.ckarthickit.tree

import java.util.*

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 *
 *  Example 1:
 *  =========
 *			Tree 1                     Tree 2
 *	          1                         2
 *	         / \                       / \
 *	        3   2                     1   3
 *	       /                           \   \
 *	      5                             4   7
 *  Output:
 *  =======
 *	Merged tree:
 *	============
 *		     3
 *		    / \
 *		   4   5
 *		  / \   \
 *		 5   4   7
 *
 * */


fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null && t2 == null) {
        return null
    }
    val mergedValue: Int =
        if (t1 != null && t2 != null) t1.`val` + t2.`val` else t1?.`val` ?: t2!!.`val`
    val mergedNode = TreeNode(mergedValue)
    mergedNode.left = mergeTrees(t1?.left, t2?.left)
    mergedNode.right = mergeTrees(t1?.right, t2?.right)
    return mergedNode
}

fun main() {
    val leftTree = TreeNode(1).also { l1 ->
        l1.left = TreeNode(3).also { l2 ->
            l2.left = TreeNode(5)
        }
        l1.right = TreeNode(2)
    }

    val rightTree = TreeNode(2).also { l1 ->
        l1.left = TreeNode(1).also { l2 ->
            l2.right = TreeNode(4)
        }
        l1.right = TreeNode(3).also { l2 ->
            l2.right = TreeNode(7)
        }
    }
    val mergedTree = mergeTrees(leftTree, rightTree)
    levelOrderTraverse(mergedTree)
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




