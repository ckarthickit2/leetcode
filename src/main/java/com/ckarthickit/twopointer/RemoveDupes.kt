package com.ckarthickit.twopointer

/**
 *  (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 *
 *  Given a sorted array nums,
 *      remove the duplicates in-place such that each element appear only once and return the new length.
 *  Do not allocate extra space for another array.
 *  You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *  Example 1 :
 *  ===========
 *  Given nums = [1,1,2],
 *  Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *  It doesn't matter what you leave beyond the returned length.
 *
 *  Example 2 :
 *  =============
 *  Given nums = [0,0,1,1,1,2,2,3,3,4],
 *  Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *  It doesn't matter what values are set beyond the returned length.
 *
 *
 *  NOTE:
 *  =====
 *  Confused why the returned value is an integer but your answer is an array?
 *  Note that the input array is passed in by reference,
 *  which means modification to the input array will be "known to the caller as well".
 */


private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 1) {
        return nums.size
    }
    //We have more than 1 element and hence element at 0th index is unique.
    //Next potential non-duplicate number can appear at the 1st index.
    var nexPotentialNonDupIndex = 1 //nexPotentialNonDupIndex is pointer 1
    for (i in 1 until nums.size) { //i is pointer 2

        //Since the array is sorted, We need to match the next non-duplicate value Only with the previous value.
        if (nums[i] != nums[nexPotentialNonDupIndex - 1]) {
            //Found another Non-Duplicate number
            swap(nums, i, nexPotentialNonDupIndex)
            nexPotentialNonDupIndex++
        }
    }
    return nexPotentialNonDupIndex //Return size
}

private fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}

fun main() {
    val arr1 = intArrayOf(1, 1, 2)
    var ret = removeDuplicates(arr1)
    println("size of [1,1,2] after removeDup = $ret")
    val arr2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    ret = removeDuplicates(arr2)
    println("size of [0,0,1,1,1,2,2,3,3,4] after removeDup = $ret")
}