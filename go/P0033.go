//题意：【jz06变式】旋转数组找数
//题解：二分，这是一个很牛逼的写法
func search(nums []int, target int) int {
    idx := bSearch(nums,0,len(nums)-1,target)
    return idx
}

func bSearch(nums []int,l,r,target int)int{
    beg := nums[l]
    for l < r{
        mid := l + ((r-l) >> 1)
        if (beg > target) != (beg > nums[mid]) != (target > nums[mid]){
                l = mid+1
        }else{
                r = mid
        }
    }
    if l == r && nums[l] == target{
        return l
    }else{
        return -1
    }
}