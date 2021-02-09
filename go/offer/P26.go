//题意：把搜索树改成双向链表，要求在原来的节点上直接改
//题解：中序遍历是有序的，所以按这个顺序改节点就可以
package main
import . "nc_tools"
/*
 * type TreeNode struct {
 *   Val int
 *   Left *TreeNode
 *   Right *TreeNode
 * }
 */

/**
 * 
 * @param pRootOfTree TreeNode类 
 * @return TreeNode类
*/
var pre *TreeNode
var head *TreeNode
func Convert( pRootOfTree *TreeNode ) *TreeNode {
    // write code here
    head, pre = nil, nil
    if pRootOfTree == nil{
        return nil
    }
    if pRootOfTree.Left==nil&&pRootOfTree.Right==nil{
            return pRootOfTree
    }
    dfs(pRootOfTree)
    return head
}

func dfs(cur *TreeNode){
    if cur == nil{
        return
    }
    dfs(cur.Left)
    if pre != nil{
        pre.Right = cur
    }
    if head == nil{
        head = cur
    }
    cur.Left = pre
    pre = cur
    dfs(cur.Right)
}