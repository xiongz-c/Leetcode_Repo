//题意：两个链表找交点
//题解：两个方法，用map或者双指针【讲一下双指针：遍历A走完从B头开始继续，B同样，最后交点就是第一次相遇的位置】
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
func FindFirstCommonNode( pHead1 *ListNode ,  pHead2 *ListNode ) *ListNode {
    // write code here
    hash := make(map[*ListNode]bool) 
    for pHead1!=nil && pHead2!=nil{
        if _,ok := hash[pHead1];!ok{
            hash[pHead1] = true
        }else{
            return pHead1
        }
        if _,ok := hash[pHead2];!ok{
            hash[pHead2] = true
        }else{
            return pHead2
        }
        pHead1 = pHead1.Next
        pHead2 = pHead2.Next
    }
    for pHead1!=nil{
        if _,ok := hash[pHead1];!ok{
            hash[pHead1] = true
        }else{
            return pHead1
        }
        pHead1 = pHead1.Next
    }
    for pHead2!=nil{
        if _,ok := hash[pHead2];!ok{
            hash[pHead2] = true
        }else{
            return pHead2
        }
        pHead2 = pHead2.Next
    }
    return nil
}