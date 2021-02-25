//题意：找下一个排列
//题解：先找到右边第一个比右边小的，再跟这个数右边恰好比他大的数交换，最后把右边的序列从小到大排序
func nextPermutation(nums []int)  {
    length := len(nums)
    idx := -1
    for i:=length-2;i>-1;i--{
        if nums[i] < nums[i+1]{
            idx = i
            break
        }
    }
    if idx>=0{
        idx2 := length-1
        for idx2 > -1 && nums[idx2]<=nums[idx]{
            idx2--
        }
        fmt.Println(idx,idx2)
        nums[idx],nums[idx2] = nums[idx2],nums[idx]
    }
    reverse(nums[idx+1:])
}

func reverse(arr []int){
    l,r := 0,len(arr)-1
    for l<r{
        arr[l],arr[r] = arr[r],arr[l]
        l++
        r--
    }
}

