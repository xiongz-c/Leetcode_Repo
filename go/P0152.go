//题意：给定数组，求乘积最大的子数组
//题解：不断迭代，求最大最小，遇到负数交换最大最小
package main

import "math"

func maxProduct(nums []int) int {
	max := ^int(^uint(0) >> 1)//最小的int
	imax := 1
	imin := 1
	for i := 0; i<len(nums); i++ {
		if nums[i] < 0 { 
		  tmp := imax;
		  imax = imin;
		  imin = tmp;
		}
		if imax*nums[i] < nums[i]{
			imax = nums[i]
		}else{
			imax = imax*nums[i]
		}
		if imin*nums[i] > nums[i]{
			imin = nums[i]
		}else{
			imin = imin*nums[i]
		}
		if max < imax{
			max = imax
		}else{
			max = max
		}
	}
	return max;
}