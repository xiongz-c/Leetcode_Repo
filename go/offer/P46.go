//题意：n个数(0~n-1)，去掉第m-1个。然后从m开始数继续去掉第m-1个，求最后一个数是多少
//题解：刚开始没想出来，其实应该数学归纳一下，相当于就是个简单的递归
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param n int整型 
 * @param m int整型 
 * @return int整型
*/
func LastRemaining_Solution( n int ,  m int ) int {
    // write code here
    if n == 0 || m == 0{
        return -1
    }
    if n == 1{
        return 0
    }
    return (LastRemaining_Solution(n-1,m)+m)%n
    
}