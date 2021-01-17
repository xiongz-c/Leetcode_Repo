// 题意：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
// 题解：二维的二分思路->从右上角开始移动，如果target更大表明同一行不可能，行数+1，如果target更小表示同一列不可能，列数-1
package main

func main(){

}

func find( target int ,  array [][]int ) bool {
    // write code here
    m := len(array)
    n := len(array[0])
    if m == 0 || n == 0{
        return false
    }
    x := 0
    y := n - 1
    for x < m && y >= 0{
        if target == array[x][y]{
            return true
        }else if target > array[x][y]{
            x++
        }else{
            y--
        }
    }
    return false
}
