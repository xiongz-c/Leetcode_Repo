//题意：反转链表
//题解：维护pre和nxt
package main
import . "nc_tools"
/*
 * type ListNode struct{
 *   Val int
 *   Next *ListNode
 * }
 */

/**
 * 
 * @param pListHead ListNode类 
 * @param k int整型 
 * @return ListNode类
*/
func ReverseList( pHead *ListNode ) *ListNode {
    // write code here
    nextNode := pHead//维护nextNode一定指向原顺序链表的下一个位置
    var preNode *ListNode
    for nextNode != nil{
        now := nextNode
        nextNode = nextNode.Next
        now.Next = preNode
        preNode = now
    }
    return preNode
}