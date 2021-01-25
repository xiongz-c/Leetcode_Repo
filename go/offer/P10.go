//题意：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
//题解：dp，dpi = dpi-1 + dpi-2
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param number int整型 
 * @return int整型
*/
func rectCover( number int ) int {
    // write code here
    if number == 0 {
        return 0
    }else if number == 1 {
        return 1
    }else if number == 2{
        return 2
    }
    var dp = make([]int, number+1)
    dp[1] = 1
    dp[2] = 2
    for i:=3;i < number+1;i++{
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[number]
}