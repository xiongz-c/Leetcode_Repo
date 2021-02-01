//题意：深拷贝带有一个随机指针的复杂链表
//题解：在原链表的基础上直接拷贝出来，然后再分离出来。暂时不知道最后一次循环剥离的时候为什么要新旧链表同时剥离，不能只剥离新的
package main

/*
type RandomListNode struct {
    Label int
    Next *RandomListNode
    Random *RandomListNode
}
*/

/**
 *
 * @param pHead RandomListNode类
 * @return RandomListNode类
*/
func Clone( head *RandomListNode ) *RandomListNode {
    //write your code here
    if head == nil{
        return nil
    }
    temp := head
    //第一次遍历，在原链表的基础上新建链表
    for temp != nil{
        copyNode := new(RandomListNode)
        copyNode.Label = temp.Label
        copyNode.Next = temp.Next
        temp.Next = copyNode
        temp = temp.Next.Next
    }
    //第二次遍历，找到random的位置
    temp = head
    for temp != nil{
        if temp.Random!=nil{
            temp.Next.Random = temp.Random.Next
        }
        temp = temp.Next.Next
    }
    //第三次遍历，分离链表
//     newHead := head.Next
//     temp = newHead
//     for temp.Next != nil{
//         temp.Next = temp.Next.Next
//         temp = temp.Next
//     }
//     return newHead
    cloneRoot := head.Next
    clone := head.Next
    cur := head
    for clone != nil {
        cur.Next = cur.Next.Next
        if clone.Next != nil {
            clone.Next = clone.Next.Next
        }
         
        clone = clone.Next
        cur = cur.Next
    }
     
    return cloneRoot
}