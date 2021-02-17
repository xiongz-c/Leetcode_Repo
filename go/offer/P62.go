//题意：找到二叉搜索树第k小
//题解：利用中序遍历有序的特点
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
 * @param pRoot TreeNode类 
 * @param k int整型 
 * @return TreeNode类
*/
var cnt int
var ans *TreeNode
func KthNode( pRoot *TreeNode ,  k int ) *TreeNode {
    // write code here
    cnt = 0
    ans = nil
    dfs(pRoot,k)
    return ans
}

func dfs(root *TreeNode,k int){
    if root == nil{
        return
    }
    dfs(root.Left,k)
    cnt++
    if cnt == k{
        ans = root
    }
    dfs(root.Right,k)
}