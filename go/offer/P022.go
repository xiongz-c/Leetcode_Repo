//题意：层序遍历二叉树
//题解：
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
 * @return int整型一维数组
*/
func PrintFromTopToBottom( root *TreeNode ) []int {
    // write code here
    if root == nil {
        return nil
    }
    queue := make([]*TreeNode , 0)
    queue = append(queue, root)
    idx :=0
    for idx < len(queue){
        if queue[idx].Left != nil{
            queue = append(queue, queue[idx].Left )
        }
        if queue[idx].Right != nil{
            queue = append(queue, queue[idx].Right)
        }
        idx++;
    }
    result := make([]int , 0)
    for _,val := range(queue){
        result = append(result, val.Val)
    }
    return result
}