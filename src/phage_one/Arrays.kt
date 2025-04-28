package phage_one

/*

max sum sub array - kaden's algo
*
*/
fun maxSumSubQn(){

    val array = intArrayOf(-5,-4,-3,-6,-1)
    // find a sub array with max sum
    // O(n^2)
//    bruteForce(array)

    // kadan's algo optimisation - discard a sub array if total sum is -ve
    kaddensAlgo(array)
}

fun kaddensAlgo(array: IntArray) {

    var maxSum =  Int.MIN_VALUE
    var curSum = 0

    for (i in array){
        curSum+=i

        if (curSum>maxSum) maxSum = curSum
        if (curSum<0) curSum = 0

    }
    println(maxSum)
}

fun bruteForce(arr:IntArray){
    //traverse 2 times with nested loop
//    save every sum compair with prev if bigger save it , if reach end return the sub array.
    var maxSum = Int.MIN_VALUE
    val arrLength = arr.lastIndex

        for (i in 0..arrLength){
            var sum = 0
        for (j in i..arrLength){
            sum+= arr[j]
            if (sum>maxSum) maxSum = sum
        }
    }
    println(maxSum)
}