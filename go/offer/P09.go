//题意：上一题的复杂版，青蛙可以跳任意级
//题解：dp， 注意是dp到0层（一次跳到的情况）
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param number int整型 
 * @return int整型
*/
func jumpFloorII( number int ) int {
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
        dp[i] = 0
        for j := i-1;j > 0;j--{
            dp[i] += dp[j]
        }
        dp[i] += 1
        
    }
    return dp[number]
}