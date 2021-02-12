//题意：判断二叉树是否平衡
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
 * 
 * @param pRoot TreeNode类 
 * @return bool布尔型
*/
func IsBalanced_Solution( pRoot *TreeNode ) bool {
    // write code here
    if pRoot == nil{
        return true
    }
    ld := deep(pRoot.Left,0)
    rd := deep(pRoot.Right,0)
    if abs(ld-rd) > 1{
        return false
    }
    return IsBalanced_Solution(pRoot.Left) && IsBalanced_Solution(pRoot.Right)
}

func deep(root *TreeNode,dep int)int{
    if root == nil{
        return dep
    }
    return max(deep(root.Left,dep+1),deep(root.Right,dep+1))
}


func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}

func abs(a int) int{
    if a < 0{
        return -a
    }
    return a
}