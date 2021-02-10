//题意：找最长不重复子串
//题解：map存值
func lengthOfLongestSubstring(s string) int {
    bmap := map[byte]int{}
    beg,maxLength := 0, 0
    for i,n:=0,len(s);i<n;i++{
        if _,ok := bmap[s[i]];ok{
            for s[beg] != s[i]{
                delete(bmap, s[beg])
                beg++
            }
            beg++
        }else{
            bmap[s[i]] = 1
            maxLength = max(maxLength, i-beg+1)
        }
    }
    return maxLength
}

func max(a, b int) int {
    if a > b{
        return a
    }
    return b
}