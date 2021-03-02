//题意：二维数组找最长递增路径长度[剪映二面]
//题解：dfs的典型应用，关联[lc p0079]
package main

import (
    "fmt"
)
func main() {
    matrix := [][]int{
        {1,30,5},
        {17,18,7},
        {15,12,9},
    }
    maxPath(matrix)
}

func maxPath(matrix [][]int){
    height := len(matrix)
    if height == 0{//exception
        return
    }
    width := len(matrix[0])
    ans := -1
    for i:=0;i<height;i++{
        for j:=0;j<width;j++{
            visited := make([][]bool,height)
            for i:=0;i<width;i++{
                visited[i] = make([]bool, width)
            }
            ans = max(ans,dfs(matrix,i,j,width,height,0,visited))
        }
    }
    fmt.Println(ans)
}

func dfs(matrix [][]int,i,j,width,height,nowLen int,visited [][]bool)int{
    visited[i][j] = true
    nowLen++
    if i > 0 && !visited[i-1][j] && matrix[i-1][j] > matrix[i][j]{
        nowLen = max(nowLen,dfs(matrix,i-1,j,width,height,nowLen,visited))
    }
    if i < height-1 && !visited[i+1][j] && matrix[i+1][j] > matrix[i][j]{
        nowLen = max(nowLen,dfs(matrix,i+1,j,width,height,nowLen,visited))
    }
    if j > 0 && !visited[i][j-1] && matrix[i][j-1] > matrix[i][j]{
        nowLen = max(nowLen,dfs(matrix,i,j-1,width,height,nowLen,visited))
    }
    if j < width-1 && !visited[i][j+1] && matrix[i][j+1] > matrix[i][j]{
        nowLen = max(nowLen,dfs(matrix,i,j+1,width,height,nowLen,visited))
    }
    return nowLen
}


func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}