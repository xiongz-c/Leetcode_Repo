//题意：青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
//题解：dp， dp = dpi-1 + dpi-2
package main

/**
 * 
 * @param number int整型 
 * @return int整型
*/
func jumpFloor( number int ) int {
    // write code here
    if number == 1{
        return 1;
    }else if number == 2{
        return 2;
    }
    var dp = make([]int, number+1)
    dp[1] = 1
    dp[2] = 2
    for i := 3;i <= number;i++{
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[number]
}