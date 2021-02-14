//题意：string转int
//题解：处理正负号，处理非数字
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param str string字符串 
 * @return int整型
*/
func StrToInt( str string ) int {
    // write code here
    length := len(str)
    if length == 0{
        return 0
    }
    bytes := []byte(str)
    sign,beg := 1,0
    if bytes[0] == '+'{
        beg=1
    }else if bytes[0] == '-'{
        beg = 1
        sign = -1
    }
    res := 0
    for beg < length{
        now := int(bytes[beg] - '0')
        if now > 9{
            return 0
        }
        res = res * 10 + now
        beg++
    }
    return sign * res
}