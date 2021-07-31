package com.ckarthickit.twopointer


/***
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 *  Example1:
 *  =========
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *  Output: [2]
 *
 *  Example2:
 *  =========
 *  Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *  Output: [9,4]
 *  Explanation: [4,9] is also accepted.
 *
 *  Solution:
 *  The idea is to convert both arrays into sets,
 *  and then iterate over the smallest set checking the presence of each element in the larger set.
 *  Time complexity of this approach is O(n+m) in the average case.
 */

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val smallerArray = if (nums1.size < nums2.size) nums1 else nums2
    val largerArray = if (smallerArray === nums2) nums1 else nums2
    val smallerSet = hashSetOf<Int>().apply {
        for (i in smallerArray.indices) add(smallerArray[i])
    }
    val largerSet = hashSetOf<Int>().apply {
        for (i in largerArray.indices) add(largerArray[i])
    }
    return intersection(smallerSet, largerSet)
//    val hasSet = hashSetOf<Int>()
//    for (si in smallerArray.indices) {
//        for (li in largerArray.indices) {
//            if (smallerArray[si] == largerArray[li] && !hasSet.contains(smallerArray[si])) {
//                hasSet.add(smallerArray[si])
//            }
//        }
//    }
//    return hasSet.toIntArray()
}

fun intersection(smallerset: HashSet<Int>, largerSet: HashSet<Int>): IntArray {
    val resultArray = IntArray(smallerset.size)
    val iterator = smallerset.iterator()
    var idx = 0
    while (iterator.hasNext()) {
        val value = iterator.next()
        if(largerSet.contains(value)) {
            resultArray[idx] = value
            idx++
        }
    }
    return resultArray.copyOf(idx)
}

fun main() {
    var ret = intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    println("ret= ${ret.contentToString()}")
    ret = intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
    println("ret= ${ret.contentToString()}")
}

