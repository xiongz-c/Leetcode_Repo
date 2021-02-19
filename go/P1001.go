//题意：找出最长的1字串，可以把k个0替换成1
//题解：等价问题->对每个right找到最小的left
func longestOnes(A []int, K int) int {
    length := len(A)
    if length <= K{
        return length
    }
    // 求0的前缀和
    zero := make([]int, length)
    zero[0] = A[0] ^ 1
    for i:=1;i<length;i++{
        if A[i] == 0{
            zero[i] = zero[i-1]+1
        }else{
            zero[i] = zero[i-1]
        }
    }
    l,r,ans := 0,0,0
    for r < length{
        if l==0 && zero[r] <= K{
            ans = max(ans,r-l+1)
            r++
        }else if l>0 && zero[r] - zero[l-1] <= K{
            ans = max(ans,r-l+1)
            r++
        }else{
            l++
        }
    }
    return ans
}

func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}