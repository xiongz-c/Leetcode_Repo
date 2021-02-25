//题意：打印二叉树和为目标的路径[路径和][目标和]
//题解：递归，注意清空全局变量，注意路径的定义是一定要到叶子节点
package main
import . "nc_tools"
import "fmt"
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
    ans=nil// 注意：这里的初始化不能用make([][]int,0),要赋值nil
    stack := make([]int,0)
    dfs(root,stack,expectNumber)
    return ans
}

func dfs(root *TreeNode,stack []int, expectNumber int){
    if root == nil{
        return
    }
    if root.Left == nil && root.Right == nil{
        if expectNumber == root.Val{
            fmt.Println(stack,expectNumber)
            ans = append(ans, append(stack,root.Val))
        }
        return
    }
    stack = append(stack, root.Val)
    dfs(root.Left,stack,expectNumber-root.Val)
    dfs(root.Right,stack,expectNumber-root.Val)
    stack = stack[:len(stack)-1]
}