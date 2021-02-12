//题意：翻转单词
//题解：reverse一下就行，这题牛客上go过不了，方法名有问题，黛比
package main
import "strings"
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param ReverseSentence string字符串 
 * @return string字符串
*/
func ReverseSentence( ReverseSentence string ) string {
    // write code here
    strs := strings.Split(ReverseSentence, " ")
    l,r := 0,len(strs)
    for l < r{
        strs[l],strs[r] = strs[r],strs[l]
        l++
        r--
    }
    return strings.Join(strs, " ")
}