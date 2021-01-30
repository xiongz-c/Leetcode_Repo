//题意：实现一个栈，O1取出最小值
//题解：min维护单调栈

package main

var arr [2000000]int
var idx int = 0
var min []int = []int{2000000000}

func Push(node int) {
    // write code here
    arr[idx] = node
    idx++
    if node <= min[len(min)-1] {
        min = append(min,node)
    }
}
func Pop() {
    // write code here
    idx--
    if arr[idx] == min[len(min)-1]{
        min = min[:len(min)-1]
    }
}
func Top() int {
    // write code here
    return arr[idx]
}
func Min() int {
	// write code here
	//这里理应加一个数组为空的判断，牛客的样例太弱了
    return min[len(min)-1]
}