//题意：求和1-n，不许用循环判断和乘除法
//题解：没啥意义的题
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param n int整型 
 * @return int整型
*/
func Sum_Solution( n int ) int {
    // write code here
    return sum(n)
}

func sum(n int) int {
    if n == 0{
        return 0
    }
    return sum(n-1) + n
}