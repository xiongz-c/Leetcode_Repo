//题意：判断字符串是不是合法数字
//题解：比较多的条件判断
package main
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param s string字符串 
 * @return bool布尔型
*/
func isNum(b byte)bool{return b-'0'<=9 && b-'0'>=0}

func isNumeric( s string ) bool {
    // write code here
    dot,exp := false,false
    for i,length:=0,len(s);i<length;i++{
        switch s[i]{
            case '+','-':
            if i+1==length || (!isNum(s[i+1]) && s[i+1] != '.'){//符号后面跟数字或.
                return false
            }
            if i!=0 && s[i-1]!='e' && s[i-1]!='E'{//符号在第一位或者e后面
                return false
            }
            case 'e','E':
            if exp || i+1==length || (!isNum(s[i+1]) && s[i+1] != '+' && s[i+1] != '-'){
                return false
            }
            exp = true
            case '.':
            if exp || dot || i+1==length || !isNum(s[i+1]) {
                return false
            }
            dot = true
            case '0','1','2','3','4','5','6','7','8','9':
            
            default:
                return false
        }
    }
    return true
}
