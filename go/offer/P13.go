//题意：调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部，保证奇偶相对顺序不变
//题解：类似于冒泡的想法。leetcode上有一题类似的，但是不需要保证奇偶相对位置不变，可以直接双指针。
//复杂度分析:可以开数组的话可以On，走两次就行了。如果不能开的话只能On^2，不需要保证相对顺序可以双指针on
package main

/**
 * 
 * @param array int整型一维数组 
 * @return int整型一维数组
*/
func reOrderArray( array []int ) []int {
    // write code here
    for i:=0;i<len(array);i++{
        j := i 
        for j > 0 && (array[j] & 1) == 1 &&  (array[j-1] & 1) == 0{
            array[j],array[j-1] = array[j-1],array[j]
            j--
        }
    }
    return array
}