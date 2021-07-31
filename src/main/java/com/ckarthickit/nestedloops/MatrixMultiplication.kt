package com.ckarthickit.nestedloops


/**
 * In Matrix Multiplication there are 3 loops
 *  The outer 2 loops represent the resultant matrix indices
 *  The inner most loop represents both the number of columns in matrix1 and number of rows in matrix 2
 */
fun multiplyMatrices(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    require(matrix1.isNotEmpty()) { "Matrix1 cannot be empty" }
    require(matrix2.isNotEmpty()) { "Matrix2 cannot be empty" }
    require(numColumns(matrix1) == numRows(matrix2)) { "Cannot multiply matrix1 and matrix2" }
    val resultArray = Array(numRows(matrix1)) {
        IntArray(numColumns(matrix2)) { 0 }
    }
    for (resultRowIndex in 0 until numRows(matrix1)) {
        for (resultColumnIndex in 0 until numColumns(matrix2)) {
            print("res[$resultRowIndex][$resultColumnIndex] = ")
            for (m1ColumnOrm2RowIndex in 0 until numRows(matrix2)) {
                print("(m1[$resultRowIndex][$m1ColumnOrm2RowIndex] * m2[$m1ColumnOrm2RowIndex][$resultColumnIndex])\t+\t")
                resultArray[resultRowIndex][resultColumnIndex] += (matrix1[resultRowIndex][m1ColumnOrm2RowIndex] * matrix2[m1ColumnOrm2RowIndex][resultColumnIndex])
            }
            println("\b\b") // To erase the "\t" added at the last, we introduce 2 back space
        }
    }
    return resultArray
}


fun numRows(matrix: Array<IntArray>): Int {
    return matrix.size
}

fun numColumns(matrix: Array<IntArray>): Int {
    if(matrix.isEmpty())
        return 0

    return matrix[0].size
}


fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach {
        it.forEach { number ->
            print("$number\t")
        }
        println()
    }
}


fun main() {
    /**
        | 1 2 |
        | 3 4 |
     */
    val matrix1 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    /**
    | 2 0 |
    | 1 2 |
     */
    val matrix2 = arrayOf(intArrayOf(2, 0), intArrayOf(1, 2))

    printMatrix(multiplyMatrices(matrix1, matrix2))

    println("==============")


    val m1 = arrayOf(intArrayOf(1,2), intArrayOf(2,1))
    val m2 = arrayOf(intArrayOf(2), intArrayOf(1))
    printMatrix(multiplyMatrices(m1, m2))
}