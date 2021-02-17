//题意：字符串路径，同Leetcode79
//题解：dfs，这里复制leetcode自己写的
package main
import "fmt"
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param matrix string字符串 
 * @param rows int整型 
 * @param cols int整型 
 * @param path string字符串 
 * @return bool布尔型
*/
func hasPath( matrix string ,  rows int ,  cols int ,  path string ) bool {
    // write code here
    m := make([][]byte,rows)
    for i:=0;i<rows;i++{
        m[i] = make([]byte, cols)
    }
    for i:=0;i<rows;i++{
        for j:=0;j<cols;j++{
            m[i][j] = byte(matrix[i*cols+j])
        }
    }
    fmt.Println(m)
    return exist(m,path)
}

func exist(board [][]byte, word string) bool {
    width:=len(board)
    if width == 0{
        return false
    }
    height:=len(board[0])
    visited := make([][]bool,width)
    for i:=0;i<width;i++{
        visited[i] = make([]bool,height)
    }
    for i:=0;i<width;i++{
        for j:=0;j<height;j++{
            if board[i][j] == word[0]{
                if dfs(string(word[0]),word,i,j,width,height,board,visited){
                    return true
                }
            }
        }
    }
    return false
}

func dfs(now, target string, i,j,width,height int, board [][]byte,visited [][]bool)bool{
    visited[i][j] = true
    if now == target{
        return true
    }
    if i+1 < width && !visited[i+1][j] && board[i+1][j] == target[len(now)]{
        if dfs( now+string(target[len(now)]), target, i+1,j,width,height,board,visited ){
            return true
        }
    }
    if j+1 < height && !visited[i][j+1] && board[i][j+1] == target[len(now)]{
        if dfs( now+string(target[len(now)]), target, i,j+1,width,height,board,visited ){
            return true
        }
    }
    if i-1 > -1 && !visited[i-1][j] && board[i-1][j] == target[len(now)]{
        if dfs( now+string(target[len(now)]), target, i-1,j,width,height,board,visited ){
            return true
        }
    }
    if j-1 > -1 && !visited[i][j-1] && board[i][j-1] == target[len(now)]{
       if dfs( now+string(target[len(now)]), target, i,j-1,width,height,board,visited ){
           return true
       }
    }
    visited[i][j] = false
    return false
}