//题意：打印二叉树和为目标的路径
//题解：递归，注意清空全局变量，注意路径的定义是一定要到叶子节点
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
 * @param root TreeNode类 
 * @param expectNumber int整型 
 * @return int整型二维数组
*/
var ans [][]int

func FindPath( root *TreeNode ,  expectNumber int ) [][]int {
    // write code here
    if root == nil{
        return nil
    }
    stack := make([]int,0)
    dfs(root, stack,0,expectNumber)
    result := ans
    ans = nil
    return result
}

func dfs(root *TreeNode, stack []int,nowNum int, target int){
    if root == nil{
        return
    }
    if nowNum == target - root.Val{
        if root.Left == nil && root.Right == nil{
            ans = append(ans,append(stack,root.Val))
        }
        return
    }
    dfs(root.Left,append(stack, root.Val),nowNum + root.Val, target)
    dfs(root.Right,append(stack, root.Val),nowNum + root.Val, target)
}