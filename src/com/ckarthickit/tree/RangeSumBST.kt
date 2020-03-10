package com.ckarthickit.tree

/**
 *  Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *  The binary search tree is guaranteed to have unique values.
 *
 *
 *  Example 1:
 *  =========
 *  Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 *  Output: 32
 *            10
 *        /      \
 *       5      15
 *     /  \       \
 *    3   7       18
 *
 *  Example 2:
 *  ==========
 *  Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 *  Output: 23
 *            10
 *         /      \
 *        5        15
 *      /  \      /  \
 *     3   7     13  18
 *    /   /
 *   1   6
 */


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    return inOrderRangeSum(root, L, R)
}

fun inOrderRangeSum(root: TreeNode?, L: Int, R: Int): Int {
    if (root == null) {
        return 0
    } else {
        var traverseLeft = true
        var traverseRight = true
        if (root.`val` < L) { //If my value is less than L , no need to traverse my Left Sub-Tree
            traverseLeft = false
        }
        if (root.`val` > R) { //If my value is greater than R, no need to traverse my Right Sub-Tree
            traverseRight = false
        }
        var sum = 0
        if (traverseLeft) {
            sum += inOrderRangeSum(root.left, L, R)
        }
        if (root.`val` >= L && root.`val` <= R) {
            sum += root.`val`
        }
        if (traverseRight) {
            sum += inOrderRangeSum(root.right, L, R)
        }
        return sum
    }
}

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5).also { sub1 ->
        sub1.left = TreeNode(3).also { sub2 ->
            sub2.left = TreeNode(1)
        }
        sub1.right = TreeNode(7).also { sub2 ->
            sub2.left = TreeNode(6)
        }
    }
    root.right = TreeNode(15).also { sub1 ->
        sub1.left = TreeNode(13)
        sub1.right = TreeNode(18)
    }
    println(inOrderRangeSum(root, 6, 10))
}