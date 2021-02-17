//题意：上一题的简化版
//题解：层序遍历
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
 * @return int整型二维数组
*/
func Print( pRoot *TreeNode ) [][]int {
    // write code here
    if pRoot == nil{
        return nil
    }
    queue := make([]*TreeNode,1)
    res := make([][]int,0)
    queue[0] = pRoot
    for len(queue)>0{
        siz := len(queue)
        for i:=0;i<siz;i++{
            if queue[i].Left!=nil{
                queue = append(queue, queue[i].Left)
            }
            if queue[i].Right!=nil{
                queue = append(queue, queue[i].Right)
            }
        }
        ans := make([]int,siz)
        for i:=0;i<siz;i++{
            ans[i] = queue[i].Val
        }
        res = append(res, ans)
        queue = queue[siz:]
    }
    return res
}