//题意：删除倒数第n个节点
//题解：不用新建头节点之前的节点，因为如果删除头会在前面判断出来直接返回掉
package main

/*
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func removeNthFromEnd(head *ListNode, n int) *ListNode {
    slow, fast := head,head
    for i:=0;i<n;i++{
        fast = fast.Next
    }
    //当n是总数时，fast走完就是nil了，会导致下面报错
    if fast == nil{
        return head.Next
    }

    for fast.Next!=nil{
        slow,fast = slow.Next,fast.Next
    }
    slow.Next = slow.Next.Next
    return head
}