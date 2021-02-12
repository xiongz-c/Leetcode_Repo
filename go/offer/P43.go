//题意：循环左移字符串
//题解：一行题...
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param str string字符串 
 * @param n int整型 
 * @return string字符串
*/
func LeftRotateString( str string ,  n int ) string {
    // write code here
    if len(str) == 0{
        return ""
    }
    n = n % len(str)
    return str[n:] + str[:n]
}