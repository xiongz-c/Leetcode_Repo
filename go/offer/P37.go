//题意：某个数在升序数组中出现的次数
//题解：二分
package main

/**
 * 
 * @param data int整型一维数组 
 * @param k int整型 
 * @return int整型
*/
func GetNumberOfK( data []int ,  k int ) int {
    // write code here
    beg := find(data,k)
    ans := 0
    length := len(data)
    for beg < length && data[beg] == k{
        ans++
        beg++
    }
    return ans
}

func find(arr []int,target int) int{
    l,r := 0,len(arr)
    for l<r{
        mid := (l+r) >> 1
        if arr[mid] < target{
            l = mid+1
        }else{
            r = mid
        }
    }
    return l
}