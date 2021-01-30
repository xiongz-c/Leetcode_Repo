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
 * @param pHead1 ListNode类 
 * @param pHead2 ListNode类 
 * @return ListNode类
*/
func Merge( pHead1 *ListNode ,  pHead2 *ListNode ) *ListNode {
    // write code here
    newHead := &ListNode{
        -1,
        nil}
    result := newHead
    for pHead1 != nil && pHead2 != nil {
        if pHead1.Val < pHead2.Val {
            newHead.Next = &ListNode{
                pHead1.Val,
                nil}
            pHead1 = pHead1.Next
        }else{
            newHead.Next = &ListNode{
                pHead2.Val,
                nil}
            pHead2 = pHead2.Next
        }
        newHead = newHead.Next                     
    }
    for pHead1 != nil {
        newHead.Next = &ListNode{
            pHead1.Val,
            nil}
        pHead1 = pHead1.Next
        newHead = newHead.Next
    }
    for pHead2 != nil {
        newHead.Next = &ListNode{
            pHead2.Val,
            nil}
        pHead2 = pHead2.Next
        newHead = newHead.Next
    }
    return result.Next
}