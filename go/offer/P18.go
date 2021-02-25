//题意：二叉树翻转[反转]
//题解：递归遍历

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
 * @return TreeNode类
*/
func Mirror( pRoot *TreeNode ) *TreeNode {
    // write code here
    dfs(pRoot)
    return pRoot
}

func dfs(root *TreeNode){
    if root == nil{
        return
    }
    if root.Left != nil{
        dfs(root.Left)
    }
    if root.Right != nil{
        dfs(root.Right)
    }
    root.Left, root.Right = root.Right, root.Left
}