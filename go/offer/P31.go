//题意：找出1-n中 1 出现的次数
//题解：技巧题，类似于找n! or n！中尾数0.具体做法看代码【牛客上暴力的解法还快一点，想不通】
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param n int整型 
 * @return int整型
*/
func NumberOf1Between1AndN_Solution( n int ) int {
    // write code here
    if n <= 0 {
        return 0
    }
    if n < 10{
        return 1
    }
    ans:=0
    for m:=1;m <= n;m *= 10{
        a := n/m 
        b := n%m
        ans += (a+8)/10 * m 
        if a%10==1{
            ans += b+1
        }
    }
    return ans
}