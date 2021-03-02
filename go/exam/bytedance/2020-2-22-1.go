//题意：判断合法括号串 param:  string  如: (()(())) output: bool
//题解：不需要用栈，直接记录有几个左括号就可以

package main

import (
    "fmt"
)
func main() {
    cnt := 0
	var str string
	fmt.Scan(&str)
	for i,n:=0,len(str);i<n;i++{
		switch str[i]{
            case '(': cnt++
            case ')':
                if cnt > 0{
                    cnt--
                }else{
                    fmt.Println(false)
                    return
                }
		}
	}
	fmt.Println(cnt==0)
}