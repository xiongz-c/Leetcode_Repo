//题意：把非递减数组的前面一部分放到后面，用二分的思想找到数组的最小值
//题解：整体思想是二分，注意一些特殊条件的处理，比如：10111
package main

/**
 * 
 * @param rotateArray int整型一维数组 
 * @return int整型
*/
func minNumberInRotateArray( rotateArray []int ) int {
    // write code here
    low := 0
    high := len(rotateArray) - 1
    mid := 0
    for low < high{
        if rotateArray[low] < rotateArray[high]{
            return rotateArray[low]//进入递增区了，只有最小的可能是答案
        }
        mid = low + (high - low) >> 1
        if rotateArray[low] < rotateArray[mid]{//这是对的，因为上面的if筛选了之后这里mid和low必须在最小值左边
            low = mid + 1
        }else if rotateArray[mid] < rotateArray[high]{
            high = mid;
        }else{
            low ++ 
        }
    }
    return rotateArray[low]
}