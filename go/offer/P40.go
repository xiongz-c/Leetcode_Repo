//题意：找出现过一次的两个数
//题解：用map，还有一种用异或的方法，通过异或出来的1分成两组再用异或得到答案。
package main

func FindNumsAppearOnce(nums []int) []int {
    //返回[a,b] 其中ab是出现一次的两个数字
    //write your code
    hash := map[int]int{}
    for i,n:=0,len(nums);i<n;i++{
        if _,ok:=hash[nums[i]];ok{
            hash[nums[i]]++
        }else{
            hash[nums[i]] = 1
        }
    }
    res := make([]int,0)
    for i,v := range hash{
        if v == 1{
            res = append(res,i)
        }
    }
    return res
}