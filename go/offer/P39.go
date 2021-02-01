//题意：判断二叉树是否平衡
//题解：递归，这里其实可以返回-1来剪枝，不过练习一下error的用法多写了一点
package main
import . "nc_tools"

import "errors"
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
    if pRoot == nil {
        return true
    }
    
    ld,err := deep(pRoot.Left,1)
    if err!=nil{
        return false
    }
    
    rd,err := deep(pRoot.Right,1)
    if err!=nil{
        return false
    }
    return ld - rd <= 1 && ld - rd >= -1
}

func deep(root *TreeNode, depth int) (int, error){
    if root == nil {
        return 0,nil
    }
    leftDepth,err := deep(root.Left,depth)
    if err!=nil{
        return 0, errors.New("not balance")
    }
    rightDepth,err := deep(root.Right,depth)
    if err!=nil{
        return 0, errors.New("not balance")
    }
    if leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1{
        return 0, errors.New("not balance")
    }
    if leftDepth > rightDepth{
        return depth + leftDepth, nil
    }else{
        return depth + rightDepth, nil
    }
}