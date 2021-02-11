//题意：求二维数组中能否有连续的字母组成目标单词
//题解：深搜永远这么麻烦！注意处理visited/string和byte的互转
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
        if dfs( now+string(target[len(now)]), target, i+1,j,width,height,board,visited){
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