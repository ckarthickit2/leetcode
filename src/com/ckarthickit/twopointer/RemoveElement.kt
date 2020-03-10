package com.ckarthickit.twopointer

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 * ===========
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * Example 2:
 * ===========
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 */

private fun removeElement(nums: IntArray, value: Int): Int {
    var rightPointer = nums.size - 1
    var leftPointer = 0
    while (leftPointer <= rightPointer) { //Left Pointer shouldn't cross rightPointer.
        if (nums[leftPointer] == value) {
            swap(nums, leftPointer, rightPointer)
            rightPointer-- //Now RighPointer points to the value being removed.
        } else {
            leftPointer++
        }
    }
    return rightPointer + 1 //Return Size (not the last index)
}

private fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}

fun main() {
    var ret = -1
    val arr1 = intArrayOf(3, 2, 2, 3)
    ret = removeElement(arr1, 3)
    println("removeEl([3,2,2,3], 3) = $ret")
    val arr2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    ret = removeElement(arr2, 2)
    println("removeEl([0,1,2,2,3,0,4,2], 2) = $ret")
    val arr3 = intArrayOf(5,5,5,5)
    ret = removeElement(arr3, 5)
    println("removeEl([5,5,5,5], 5) = $ret")
}