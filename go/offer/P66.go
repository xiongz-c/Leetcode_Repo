//题意：判断某个点能否到达，到达的条件是这个点坐标各个位数和不超过k，且只能上下左右移动
//题解：比较简单的dfs，不需要回溯
package main
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param threshold int整型 
 * @param rows int整型 
 * @param cols int整型 
 * @return int整型
*/
func movingCount( threshold int ,  rows int ,  cols int ) int {
    // write code here
    if threshold < 0{
        return 0
    }
    visited := make([][]bool,rows)
    for i:=0;i<rows;i++{
        visited[i] = make([]bool,cols)
    }
    dfs(visited,0,0,rows,cols,threshold)
    ans := 0
    for i:=0;i<rows;i++{
        for j:=0;j<cols;j++{
            if visited[i][j]{
                ans++
            }
        }
    }
    return ans
}

func dfs(visited [][]bool, i,j,rows,cols,threshold int){
    if visited[i][j] || !check(i,j,threshold){
        return
    }
    visited[i][j] = true
    if i+1<rows{
        dfs(visited,i+1,j,rows,cols,threshold)
    }
    if i-1>-1{
        dfs(visited,i-1,j,rows,cols,threshold)
    }
    if j+1<cols{
        dfs(visited,i,j+1,rows,cols,threshold)
    }
    if j-1>-1{
        dfs(visited,i,j-1,rows,cols,threshold)
    }
}

func check(i,j,threshold int)bool{
    res:=0
    for {
        res += i%10
        i /= 10
        if i == 0{
            break
        }
    }
    for {
        res += j%10
        j /= 10
        if j == 0{
            break
        }
    }
    
    return res <= threshold
}