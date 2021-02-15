//题意：判断对称二叉树
//题解：递归
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
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param pRoot TreeNode类 
 * @return bool布尔型
*/
func isSymmetrical( pRoot *TreeNode ) bool {
    // write code here
    return pRoot == nil || dfs(pRoot.Left,pRoot.Right)
}

func dfs(left,right *TreeNode)bool{
    if left == nil && right == nil{
        return true
    }else if left == nil || right == nil{
        return false
    }
    if left.Val != right.Val{
        return false
    }
    return dfs(left.Left,right.Right) && dfs(left.Right,right.Left)
}