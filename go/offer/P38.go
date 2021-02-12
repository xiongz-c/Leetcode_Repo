//题意：求深度
//题解：dfs
package main

func TreeDepth( pRoot *TreeNode ) int {
    // write code here
    return dfs(pRoot,0)
}

func dfs(root *TreeNode, dep int) int{
    if root == nil{
        return dep
    }
    return max(dfs(root.Left,dep+1),dfs(root.Right,dep+1))
}

func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}