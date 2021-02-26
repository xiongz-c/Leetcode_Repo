//题意：满足最大值和最小值的差小于limit的最长窗口[滑动窗口][单调队列]
//题解：快速取区间最大最小值联想到单调队列，维护两个单调队列。然后控制一个left游标进行滑动窗口取最大的窗口长度为答案
func longestSubarray(nums []int, limit int) int {
    minQ,maxQ := make([]int,0),make([]int,0)
    left,ans := 0,-1
    for i:=0;i<len(nums);i++{
        for len(maxQ) > 0 && nums[i] > nums[maxQ[len(maxQ)-1]]{
            maxQ = maxQ[:len(maxQ)-1]
        }
        maxQ = append(maxQ,i)
        for len(minQ) > 0 && nums[i] < nums[minQ[len(minQ)-1]]{
            minQ = minQ[:len(minQ)-1]
        }
        minQ = append(minQ,i)
        fmt.Println("delta:",nums[maxQ[0]] - nums[minQ[0]])
        for nums[maxQ[0]] - nums[minQ[0]] > limit{
            left++
            for maxQ[0] < left{
                maxQ = maxQ[1:]
            }
            for minQ[0] < left{
                minQ = minQ[1:]
            }
        }
        ans = max(ans,i-left+1)
    }
    return ans
}
func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}