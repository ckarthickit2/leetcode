package com.ckarthickit.tree

import java.util.*

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 *	For this problem,
 *  a height-balanced binary tree is defined as a binary tree in which
 *  the depth of the two   subtrees of every node never differ by more than 1.
 *
 *	Example:
 *	=========
 *
 *	Given the sorted array: [-10,-3,0,5,9],
 *
 *	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *	      0
 *	     / \
 *	   -3   9
 *	   /   /
 *	 -10  5
 *
 *
 */

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return sortedArrayToBST(nums, 0, nums.size - 1)
}

fun sortedArrayToBST(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
    if (startIndex < 0 || endIndex >= nums.size || startIndex > endIndex) {
        return null
    }
    val midIndex = startIndex + (endIndex - startIndex) / 2
    val node = TreeNode(nums[midIndex])
    node.left = sortedArrayToBST(nums, startIndex, midIndex - 1)
    node.right = sortedArrayToBST(nums, midIndex + 1, endIndex)
    return node
}

fun main() {
    val array = intArrayOf(-10,-3,0,5,9)
    val root = sortedArrayToBST(array)
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