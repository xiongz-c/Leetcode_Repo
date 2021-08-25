//题意：给定数组，求乘积最大的子数组
//题解：不断迭代，求最大最小，遇到负数交换最大最小
package main

import "math"

func maxProduct(nums []int) int {
	maxNum := math.MinInt32
	imax, imin := 1, 1
	for _, v := range nums {
		if v < 0 {
			imax, imin = imin, imax
		}
		imax = max(v, imax*v)
		imin = min(v, imin*v)
		maxNum = max(maxNum, imax)
	}
	return maxNum
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}