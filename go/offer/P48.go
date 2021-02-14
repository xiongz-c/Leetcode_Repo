//题意：位运算实现加法
//题解：看代码
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param num1 int整型 
 * @param num2 int整型 
 * @return int整型
*/
func Add( num1 int ,  num2 int ) int {
    // write code here
    res,carr := 0,0
    for{
        res = num1 ^ num2
        carr = (num1 & num2) << 1
        num1 = res
        num2 = carr
        if carr == 0{
            break
        }
    }
    return res
}