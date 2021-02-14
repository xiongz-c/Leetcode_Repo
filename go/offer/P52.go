//题意：实现简单正则，只有*和.
//题解：dp， 考虑两大类：1.直接匹配【.和相等】2.带*匹配【匹配0个和匹配1个】
package main
import "fmt"
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param s string字符串 
 * @param pattern string字符串 
 * @return bool布尔型
*/
func match( s string ,  pattern string ) bool {
    // write code here
    sLen,pLen := len(s),len(pattern)
    dp := make([][]bool,pLen+1)
    for i:=0;i<=pLen;i++{
        dp[i] = make([]bool, sLen+1)
    }
    for i:=0;i<=pLen;i++{
        for j:=0;j<=sLen;j++{
            switch{
                case i == 0://pattern is ""
                    dp[i][j] = j == 0
                case i > 1 && pattern[i-1] == '*': 
                    dp[i][j] = (j>0 && (s[j-1] == pattern[i-2] || pattern[i-2] == '.' ) && dp[i][j-1]) || (dp[i-2][j])
                case j > 0 && (s[j-1] == pattern[i-1] || pattern[i-1] == '.')://one to one match
                    dp[i][j] = dp[i-1][j-1]
                
            }
        }
    }
    fmt.Println(dp)
    return dp[pLen][sLen]
}