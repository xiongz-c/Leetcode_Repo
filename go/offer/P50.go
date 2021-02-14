//题意：找出数组中第一个重复的数
//题解：随便写。。但是这题牛客上好像go过不了
package main

func Duplicate(numbers []int, duplication *[1]int) bool{
    length := len(numbers)
    if length == 0{
        duplication[0] = -1
        return false
    }
    repeat := make([]int, length)
    for _,v := range numbers{
        if repeat[v]>0{
            duplication[0] = v 
            return true
        }else{
            repeat[v] = 1
        }
    }
    duplication[0] = -1
    return false
}