//题意：倒序打印链表
//题解；注意go append的用法，用于连接两个切片时加...表示解构

package main

type ListNode struct{
   Val int
   Next *ListNode
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param head ListNode类 
 * @return int整型一维数组
*/
func printListFromTailToHead( head *ListNode ) []int {
    // write code here
    var arr []int
    for head != nil {
        arr2 := make([]int, 1)
        arr2[0] = head.Val
        arr = append(arr2,arr...)
        head = head.Next
    }
    return arr
}