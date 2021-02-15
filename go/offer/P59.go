//题意：之子型打印树
//题解：层序遍历，区分一下层数就可以
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
 * @return int整型二维数组
*/
func Print( pRoot *TreeNode ) [][]int {
    // write code here
    if pRoot == nil{
        return nil
    }
    queue := make([]*TreeNode, 1)
    queue[0] = pRoot
    odd := false
    res := make([][]int,0)
    for len(queue) > 0{
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
        if !odd{
            for i:=0;i<siz;i++{
                ans[i] = queue[i].Val
            }
        }else{
            for i:=0;i<siz;i++{
                ans[siz-i-1] = queue[i].Val
            }
        }
        res = append(res, ans)
        odd = !odd
        queue = queue[siz:]
    }
    return res
}