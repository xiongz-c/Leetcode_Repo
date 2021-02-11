//题意：找到第一个之重复了一次的字符的位置
//题解：简单题，扫一次用map记录
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param str string字符串 
 * @return int整型
*/
func FirstNotRepeatingChar( str string ) int {
    // write code here
    m := make(map[byte]int)
    for i:=0;i<len(str);i++{
        if _,ok := m[str[i]];!ok{
            m[str[i]] = i
        }else{
            m[str[i]] = -1
        }
    }
    ans := len(str)
    for _,v := range m{
        if v!=-1{
            if v < ans{
                ans = v
            }
        }
    }
    if ans == len(str){
        return -1
    }
    return ans
}