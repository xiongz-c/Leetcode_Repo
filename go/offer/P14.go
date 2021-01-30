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
func FindKthToTail( pListHead *ListNode, k int ) *ListNode {
    // write code here
    tail := pListHead
    target := pListHead
    for i:=0;i<k;i++{
        if tail == nil{
            return nil
        }
        tail = tail.Next
    }
    for tail!=nil{
        target, tail = target.Next, tail.Next
    }
    return target
}