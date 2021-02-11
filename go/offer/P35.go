//题意：找逆序对
//题解：背好mergesort
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param data int整型一维数组 
 * @return int整型
*/
var nums []int
var arr []int
var ans int
func InversePairs( data []int ) int {
    length := len(data)
    if length == 0{
        return 0
    }
    // write code here
    ans = 0
    arr = data
    nums = make([]int, length)
    mergeSort(0,length-1)
    return ans
}

func mergeSort(l,r int){
    if l == r{
        return
    }
    mid := (l+r) >> 1
    i,j,k := l,mid+1,l
    mergeSort(l,mid)
    mergeSort(mid+1,r)
    for i <= mid && j <=r {
        if arr[i] <= arr[j]{
            nums[k] = arr[i]
            k++
            i++
        }else{
            nums[k] = arr[j]
            k++
            j++
            ans = (ans+mid-i+1)%1000000007
        }
    }
    for i <= mid{
        nums[k] = arr[i]
        k++
        i++
    }
    for j <= r{
        nums[k] = arr[j]
        k++
        j++
    }
    for beg:=l;beg<=r;beg++{
        arr[beg] = nums[beg]
    }
}