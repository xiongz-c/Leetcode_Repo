//题意：至少有k个重复字符的最长子串
//题解:归并的做法，对于一个字符串，如果出现了某个字符出现了但不足k次，就一定不能满足题意，此时可以把字符串以该字符分割，判断字串
func longestSubstring(s string, k int) (ans int) {
    cnt := map[rune]int{}
    for _,v:=range s{
        cnt[v]++
    }
    var split rune
    for i,v := range cnt{
        if v >= 0 && v < k{
            split = i 
            break
        }
    }
    if split == 0{
        return len(s)
    }
    for _,v := range strings.Split(s,string(split)){
        ans = max(ans,longestSubstring(v,k))
    }
    return ans
}

func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}