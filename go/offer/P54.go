//题意：设计函数获取字符流中第一个只出现了一次的字符
//题解：用一个map记录出现次数，用一个queue把第一次出现的字符存了，取的时候判断首位是不是第一次出现的
package main

var hash [256]int
var queue []byte
func Insert(ch byte) {
    if hash[int(ch)] == 0{
        queue = append(queue, ch)
    }
    hash[int(ch)]++
}

func FirstAppearingOnce() byte {
    for len(queue) > 0 && hash[int(queue[0])] > 1{
        queue = queue[1:]
    }
    if len(queue) == 0{
        return '#'
    }
    return queue[0]
}