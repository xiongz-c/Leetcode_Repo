//题意：斐波那契
//题解：简单题，练语法
package main

/**
 * 
 * @param n int整型 
 * @return int整型
*/
func Fibonacci( n int ) int {
    // write code here
    if n == 0{
        return 0
    }else if n == 1{
        return 1
    }
    var a = make([]int, n+1)
    a[0] = 0
    a[1] = 1
    for i := 2;i<=n;i++{
        a[i] = a[i-2] + a[i-1] 
    }
    return a[n]
}