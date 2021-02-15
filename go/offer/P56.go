//题意：删除链表中重复的数字
//题解：注意要开一个新的头节点方便删除头部
package main
import . "nc_tools"
/*
 * type ListNode struct{
 *   Val int
 *   Next *ListNode
 * }
 */

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param pHead ListNode类 
 * @return ListNode类
*/
func deleteDuplication( pHead *ListNode ) *ListNode {
    // write code here
    newhead := &ListNode{-1,pHead}
    head := newhead
    hash := map[int]bool{}
    for head != nil{
        nxt := head.Next
        isDel := false 
        if nxt!=nil && nxt.Next!=nil && nxt.Val == nxt.Next.Val{
            hash[nxt.Val] = true
            isDel = true
        }
        for nxt!=nil{
            if _,ok:=hash[nxt.Val];!ok{
               break
            }
            nxt = nxt.Next
        }
        head.Next = nxt
        if !isDel{
            head = head.Next
        }
    }
    return newhead.Next
}