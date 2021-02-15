//题意：环形链表找入口
//题解：老两样：hashmap和双指针。双指针快的2慢的1，第一次相遇后快的回到头部然后两个同时1，再次相遇就是环形路口。

package main

func EntryNodeOfLoop(pHead *ListNode) *ListNode{
    hash := map[*ListNode] bool{}
    for pHead!=nil{
        if _,ok:=hash[pHead];ok{
            return pHead
        }else{
            hash[pHead] = true
        }
        pHead = pHead.Next
    }
    return nil
}