//题意：找中序遍历的下一个节点
//题解：分三种情况：存在右节点->找右节点下的最左节点；存在父节点->迭代判断是不是左子节点；最后一个
package main

/*
type TreeLinkNode struct {
    Val int
    Left *TreeLinkNode
    Right *TreeLinkNode
    Next *TreeLinkNode
}
*/

func GetNext(pNode *TreeLinkNode) *TreeLinkNode {
    if pNode == nil{
        return nil
    }
    
    if pNode.Right != nil{
        now := pNode.Right
        for now.Left!=nil{
            now = now.Left
        }
        return now
    }
    
    for pNode.Next!=nil{
        root := pNode.Next
        if root.Left == pNode{
            return root
        }
        pNode = pNode.Next
    }
    
    return nil
}