//题意：数轴上n个点，给定一个距离d，求所有三点最大距离不超过d的组合数量
//题解：滑动窗口，组合数计算。注意移动的是左端点，以及取模的问题
package main

import "fmt"

func Cal(num int) int{
    return num * (num-1) / 2
}

func main(){
    var n int
    var d int
    fmt.Scanf("%v %v\n",&n,&d)
    seq := make([]int,0)
    for i:= 0;i<n;i++{
        var tmp int
        fmt.Scan(&tmp)
        seq = append(seq,tmp)
    }
    length := len(seq)
    cnt := 0
    if length < 3{
        fmt.Println(cnt)
        return
    }
    beg,end := 0,2    
    for end<length{
        for seq[end]-seq[beg] > d{
            beg++
        }
        cnt = (cnt + Cal(end-beg)% 99997867) % 99997867
        end++
    }
    fmt.Println(cnt % 99997867)
}