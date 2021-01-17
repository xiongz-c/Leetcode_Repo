//题意：用两个栈实现一个队列
//题解：stack1用于存数据，stack2用于倒序
package main

var stack1 [] int
var stack2 [] int

func Push(node int) {
    stack1 = append(stack1,node)
}

func Pop() int{
    for i := len(stack1)-1;i >= 0;i--{
        stack2 = append(stack2,stack1[i])
    }
    stack1 = stack1[1:len(stack1)]
    res := stack2[len(stack2)-1]
    stack2 = stack2[0:0]
    return res
}