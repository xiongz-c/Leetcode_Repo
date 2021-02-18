//题意：长度为n的木头，求切成几段每一段长度乘积有最大值，返回最大值
//题解：dp，每次都遍历一遍之前的结果求最值。这题牛客上go过不了
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param number int整型 
 * @return int整型
*/
func cutRope( number int ) int {
    // write code here
    if number < 4{
        return number-1
    }
    dp := make([]int, number+1)
    for i:=1;i<=4;i++{
        dp[i] = i
    }
    for i:=5;i<=number;i++{
        for j:=1;j<i;j++{
            dp[i] = max(dp[i],j * dp[i-j])
        }
    }
    return dp[number]
}

func max(a,b int)int{
    if a>b {
        return a
    }
    return b
}