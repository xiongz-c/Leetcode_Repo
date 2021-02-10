//题意：连续子数组的最大和
//题解：dp
package main

/**
 * 
 * @param array int整型一维数组 
 * @return int整型
*/
func FindGreatestSumOfSubArray( array []int ) int {
    // write code here
    ans,dp := -200000,0
    for _,v:=range array{
        dp = max(dp + v,v)
        ans = max(ans,dp)
    }
    return ans
}

func max(a,b int) int{
    if a>b{
        return a
    }
    return b
}