//题意：二进制中1的个数
//题解：移位与1
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param n int整型 
 * @return int整型
*/
func NumberOf1( n int ) int {
    // write code here
    cnt := 0
    loop := 32
    for n != 0 && loop > 0 {
        cnt += n & 1
        n >>= 1
        loop--
    }
    return cnt
}