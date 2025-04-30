package phage_one

import kotlin.math.max
import kotlin.math.min

/*

max sum sub array - kaden's algo
*
*/
class MaxSumSubQn {


    // find a sub array with max sum

    object MaxSum {

        private val arr = intArrayOf(-5, -4, -3, -6, -1)

        val maxSum = kaddensAlgo(arr)

        fun kaddensAlgo(array: IntArray) {
            // kadan's algo optimisation - discard a sub array if total sum is -ve

            var maxSum = Int.MIN_VALUE
            var curSum = 0

            for (i in array) {
                curSum += i

                if (curSum > maxSum) maxSum = curSum
                if (curSum < 0) curSum = 0

            }
            println(maxSum)
        }

        fun bruteForce(arr: IntArray) {
            // O(n^2)
//    bruteForce(array)

            //traverse 2 times with nested loop
//    save every sum compair with prev if bigger save it , if reach end return the sub array.
            var maxSum = Int.MIN_VALUE
            val arrLength = arr.lastIndex

            for (i in 0..arrLength) {
                var sum = 0
                for (j in i..arrLength) {
                    sum += arr[j]
                    if (sum > maxSum) maxSum = sum
                }
            }
            println(maxSum)
        }
    }


}


object StoksByeSell {

    private val stok = intArrayOf(3, 5, 1, 7, 4, 9, 3)

    // now most profit i make if i buy at 1 sell at 9

    val profit = maxProfitMaker()


    fun bruteForce() {
        // n^2 time for 2 traverce and checking diffrence between each no . and storing the max


    }

    fun usingSpace(){
        // if I know what's the highest value coming .
        val futureList = stok.clone()
       /** now if i directly assign stocks to new array it will be an ref to the same array so
        here are some methord to solve this issue*/
        /*
        // Option 1: Use copyOf()
val array1 = intArrayOf(1, 2, 3)
val array2 = array1.copyOf()

// Option 2: Use sliceArray
val array2 = array1.sliceArray(array1.indices)

// Option 3: Use clone() (for primitive arrays)
val array2 = array1.clone()

// Option 4: Use toIntArray() after converting to list
val array2 = array1.toList().toIntArray()
        */
       var finalProfit: Int = -1
        var big = Int.MIN_VALUE
        for (i in stok.lastIndex downTo 0) {

            if (stok[i] > big) big = stok[i]

            futureList[i] = big
        }

        //chks both arrays and return answar
        for (i in 0..stok.lastIndex) {

            var profitNow = futureList[i] - stok[i]

            finalProfit = if (finalProfit > profitNow) {
                finalProfit
            } else {
                profitNow
            }

        }

        println(finalProfit)
    }

    fun mostOptimised(){
        // if I know what's the highest value coming .
        var minValueSoFar = stok[0]
        var finalProfit: Int = 0

        for (i in 0..stok.lastIndex){

            minValueSoFar = min(minValueSoFar, stok[i])
            // try to sell in each index
            var profitNow = stok[i] - minValueSoFar
            finalProfit = max(finalProfit,profitNow)
        }

        println(finalProfit)
    }


    //if u do buy sell multiple times

    fun maxProfitMaker(){

        var finalProfit = 0

        for (i in 1..stok.lastIndex){

            var profit = (stok[i] - stok[i-1])
            if (profit> 0){
                finalProfit+=profit
            }
        }
        println(finalProfit)
    }

}

object TappingWater{

    val height = intArrayOf(3,1,2,4,0,1,3,2)// ans =8


    fun tappRainWater()  {

        val left = height.clone()
        val right = height.clone()

        var leftMaxCount = Int.MIN_VALUE
        var rightMaxCount = Int.MIN_VALUE
        var water = 0

        for(i in 0..height.lastIndex){
            leftMaxCount = max(leftMaxCount , left[i])
            left[i] = leftMaxCount
        }

        for(i in height.lastIndex downTo 0){
            rightMaxCount = max(rightMaxCount , right[i])
            right[i] = rightMaxCount
        }

        for(i in 0..height.lastIndex){
            var possibleWater = min(right[i] , left[i])

            water+= possibleWater - height[i]
        }

        println(water)
    }
}

object SortingAlgos{

    val arr = intArrayOf(3,1,2,4,0,1,3,2)// ans =8

    fun printSortedArr(){

        arr.quickSort(0, arr.lastIndex)
        println(arr.joinToString())
    }

    fun IntArray.bubbleSort():Unit{

        // O(n^2) worst best = O(n)
        var swapped = false

        for (i in 0..this.lastIndex){

            for (j in 0..<(this.lastIndex-i)){

               if (arr[j] > arr[j+1] ) {
                   swap(arr, j+1, j)
                   swapped = true
               }
            }
            //further optimisation for sorted array
            if (!swapped){
                break
            }
        }
    }

    fun IntArray.insertionSort(){
        //2 part sorted and unsorted
        var temp :Int
        for (i in 1..arr.lastIndex){

            temp = arr[i]
            var j = i-1

            while ( j>=0 && arr[j] > temp ){
                arr[j+1] = arr[j]
                j--
            }
            arr[j+1] = temp
        }


    }

    fun IntArray.selectionSort(){

        var min :Int

        for(i in 0..<arr.lastIndex){

            min=i
            for (j in i+1..(arr.lastIndex)){

                if (arr[j]< arr[min]) {
                    min = j
                }
            }
            if (min != i){
                swap(arr,min,i)
            }
        }
    }

    fun IntArray.quickSort(low: Int,high: Int){

        if(low<high){
            var pivot = SortingAlgos.partition(low, high)

            this.quickSort(low,pivot-1)
            this.quickSort(pivot+1,high)
        }
    }

    fun partition(low:Int, high:Int):Int {
        var pivot = low

        var i = low
        var j = high

        while (i<j){

            while (arr[i] <= arr[pivot]) i++

            while (arr[j] > arr[pivot]) j--

            if (i < j){
                swap(arr,i, j)
            }
        }
        swap(arr, low, j)
        return j
    }
    fun swap(arr:IntArray,i:Int ,j:Int){
        var temp = arr[i]

        arr[i] =arr[j]
        arr[j] = temp
    }


}