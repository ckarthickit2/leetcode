package com.ckarthickit.nestedloops


/*

   &nbsp; &nbsp; &nbsp; &nbsp; *
   &nbsp; &nbsp; &nbsp;   *    *
   &nbsp; &nbsp;   *      *    *
   &nbsp;   *      *      *    *
     *      *      *      *    *

 */
fun printStarPattern3(numCellsInAnAxis: Int) {
    for(rowIndex in 0 until numCellsInAnAxis) {
        for(columnIndex in 0 until numCellsInAnAxis) {

            /**
             * The below if condition can also be written as :
             *
             *  - numCellsInAnAxis.sizeToIndex() - columnIndex <= rowIndex
             *  - numCellsInAnAxis.sizeToIndex() - columnIndex + columnIndex <= rowIndex + columnIndex
             *  - numCellsInAnAxis.sizeToIndex() <= rowIndex + columnIndex
             *  - rowIndex + columnIndex >= numCellsInAnAxis.sizeToIndex()
             *
             *  by modifying the "Inequalities" as per rules
             */
            if(numCellsInAnAxis.sizeToIndex() - columnIndex <= rowIndex) {
                print("*\t")
            }else {
                print("\t")
            }
        }
        println()
    }
}


/*
     &nbsp;     &nbsp;     &nbsp;        *       &nbsp;     &nbsp;     &nbsp;
     &nbsp;     &nbsp;        *       &nbsp;        *       &nbsp;     &nbsp;
     &nbsp;        *       &nbsp;        *       &nbsp;        *       &nbsp;
       *        &nbsp;        *       &nbsp;        *       &nbsp;        *

       ith row has i stars, (i-1) spaces in between the stars and (i*2)-1 columns
       So total spaces at start = (n - (i + i-1)) / 2

       * calculating total Stars at the start is the key .
       * After that it is just printing the number of stars for that row in alternate spaces
 */
fun printStarPattern4(numRows: Int) {
    val numColumns = (numRows * 2) - 1
    for(rowIndex in 1..numRows) {
        val numStars: Int = rowIndex
        val numSpacesBetweenStars = numStars - 1
        val numSpacesAtStartAndEnd = (numColumns - (numStars + numSpacesBetweenStars)) / 2
        for(columnIndex in 0 until numSpacesAtStartAndEnd) {
            print("\t")
        }
        var nextPrintStar = true
        var printedStarCount = 0
        while(printedStarCount < numStars) {
            if(nextPrintStar) {
                print("*\t")
                printedStarCount++
                nextPrintStar = false
            }else {
                print("\t")
                nextPrintStar = true
            }
        }
        println()
    }
}

/**
 * Another approach is
 *  numberOfStartingSpace in ith row in (numRows-i)
 *  numberofStars in ith row is i
 */
fun printStarPattern4Variant(numRows: Int) {
    // If we alternatively uncomment the commented print, then we get Pattern3
    for(rowIndex in 1..numRows) {
        for(startingSpaceIndex in  1..(numRows-rowIndex)) {
            print(" ")
            //print("\t")
        }
        for(starsIndex in 1..rowIndex) {
            print("* ")
            //print("*\t")
        }
        println()
    }
}

fun Int.sizeToIndex(): Int {
    return this - 1
}

fun main() {
    println("Enter number of vertical cells (or) horizontal cells")
    val rows = readLine()?.toInt() ?: 5
    printStarPattern3(rows)
    println("===============")
    printStarPattern4(rows)
    println("===============")
    printStarPattern4Variant(rows)
}