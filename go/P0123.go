//题意：股票买卖最难的情况，最多可以买卖两次求最大收益
//题解：dp，java写过一次，但是忘了（可能当时看的题解）dp[i][0/1][0/1/2]:第i天，是否持有，卖了几次
package main

import "fmt"

func main(){
	var n int
	fmt.Scan(&n)
	arr:=make([]int, n)
	for i:=0;i<n;i++{
		fmt.Scan(&arr[i])
	}
	fmt.Println(maxProfit(arr))
}

func maxProfit(prices []int) int {
	length := len(prices)
	if length == 0{
		return 0
	}
    dp := make([][2][3]int, length)//注意多维数组的初始化方式，可以看作由二维数组的组成的slice
	dp[0][0][0],dp[0][1][0] = 0,-prices[0]	
	dp[0][0][1],dp[0][0][2],dp[0][1][1],dp[0][1][2] = -100001,-100001,-100001,-100001

	for i:=1;i<length;i++{
		dp[i][0][0] = 0
		dp[i][0][1] = max(dp[i-1][0][1], prices[i] + dp[i-1][1][0])//以前卖的/今天卖的
		dp[i][0][2] = max(dp[i-1][0][2], prices[i] + dp[i-1][1][1])//以前卖了两次/今天卖第二次
		dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][0][0] - prices[i])//以前买的/今天买的
		dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][1] - prices[i])//以前买的/今天买的
		// dp[i][1][2] = -100001//不可能卖了两次还能持有
	}
	return max(dp[length-1][0][2],max(dp[length-1][0][1],0))

}

func max(x int, y int) int{
	if x > y{
		return x
	}
	return y
}

