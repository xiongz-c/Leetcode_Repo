//题意：划分字符串片段，让相同的字符出现在同一片段
//题解：两次for循环
package main

import "fmt"

func partitionLabels(S string) []int {
    ans := make([]int, 0)
    lastIndex := make([]int, 26)
    for i,v := range(S){
        lastIndex[int(v-'a')] = i
    }
    fmt.Println(lastIndex)
    beg, end := -1,0
    for i,v := range(S){
        if end > lastIndex[int(v-'a')]{
            end = end
        }else{
            end = lastIndex[int(v-'a')]
        }
        fmt.Println(beg,end)
        if end == i{
            ans = append(ans, end-beg)
            beg = end
        }
    }
    return ans
}