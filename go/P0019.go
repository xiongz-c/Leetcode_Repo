package main

/*
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }

 注意处理把头部删除的特殊情况
 */
 func removeNthFromEnd(head *ListNode, n int) *ListNode {
    nxt := head
    pre := head
    for i :=0;i<n;i++{
        nxt = nxt.Next
    }
    if nxt==nil {
        if n == 1{
            return nil
        }
        return head.Next
    }
    for nxt.Next != nil{
        pre , nxt = pre.Next, nxt.Next
    }
    pre.Next = pre.Next.Next
    return head
}