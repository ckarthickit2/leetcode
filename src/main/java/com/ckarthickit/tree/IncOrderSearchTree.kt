package com.ckarthickit.tree

/**
 *
 * Given a binary search tree,
 * rearrange the tree in in-order so that
 * 1) the leftmost node in the tree is now the root of the tree,
 * 2) and every node has no left child and only 1 right child.
 *
 * Example 1:
 * ==========
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 *	Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *	 1
 *	  \
 *	   2
 *	    \
 *	     3
 *	      \
 *	       4
 *	        \
 *	         5
 *	          \
 *	           6
 *	            \
 *	             7
 *	              \
 *	               8
 *	                \
 *	                 9
 *
 */
fun increasingBST(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val arrayList = arrayListOf<TreeNode>()
    increasingBST(root, arrayList)
    val root = TreeNode(0)
    var curNode = root
    for (node in arrayList) {
        curNode.right = node
        curNode = curNode.right!!
    }
    return root.right
}

fun increasingBST(curNode: TreeNode, list: ArrayList<TreeNode>) {
    if (curNode.left != null) {
        increasingBST(curNode.left!!, list)
    }
    curNode.left = null //Left Traversal already done
    list.add(curNode)
    if (curNode.right != null) {
        increasingBST(curNode.right!!, list)
    }
}

fun main() {
    val root = TreeNode(5).also { r ->
        r.left = TreeNode(3).also { l1 ->
            l1.left = TreeNode(2).also {
                it.left = TreeNode(1)
            }
            l1.right = TreeNode(4)
        }
        r.right = TreeNode(6).also { r ->
            r.right = TreeNode(8).also { l1 ->
                l1.left = TreeNode(7)
                l1.right = TreeNode(9)
            }
        }
    }
    val newRoot = increasingBST(root)
    println(newRoot?.`val`)
}