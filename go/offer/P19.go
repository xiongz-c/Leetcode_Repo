//题意：旋转打印二维数组
//题解：注意边界条件的判断
package main
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param matrix int整型二维数组 
 * @return int整型一维数组
*/

type Vector struct{
    x int
    y int
}

func printMatrix( matrix [][]int ) []int {
    // write code here
    n := len(matrix)
    m := len(matrix[0])
    vec := [4]Vector{{0,1},{1,0},{0,-1},{-1,0}}
    nowVec := 0
    visited := make([][]bool, n)
    for i := 0; i < n; i++ {
        visited[i] = make([]bool, m)
    }
    i,j := 0,0
    result := make([]int,0)
    for{
        result = append(result,matrix[i][j])
		visited[i][j] = true
		//这里是对数组越界的约束
        for idx:=0;idx<5;idx++{
            if idx == 4{
                    return result
            }
            if  i + vec[nowVec].x < 0 || i + vec[nowVec].x > n-1{
                nowVec++;
                nowVec %= 4
                continue
            }
            if  j + vec[nowVec].y < 0 || j + vec[nowVec].y > m-1{
                nowVec++;
                nowVec %= 4
                continue
            }
            break
		}
		//这里是对已访问的约束
        if visited[i + vec[nowVec].x][j + vec[nowVec].y]{
            for idx:=0;idx<5;idx++{
                if idx == 4{
                    return result
                }
                nowVec++;
                nowVec %= 4;
                if  i + vec[nowVec].x < 0 || i + vec[nowVec].x > n-1{
                    continue
                }
                if  j + vec[nowVec].y < 0 || j + vec[nowVec].y > m-1{
                    continue
                }
                if !visited[i + vec[nowVec].x][j + vec[nowVec].y]{
                    break
                }
                
            }
		}
		//清除障碍之后就可以往后打印了
        i += vec[nowVec].x
        j += vec[nowVec].y
    }
    return result    
}