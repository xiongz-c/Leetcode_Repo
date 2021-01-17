// 题意：简单字符串替换
// 题解：bufffer类可以使拼接更快速
package main

import "bytes"

func main(){

}

func replaceSpace(s string) string {
	//write your code here
    var buffer bytes.Buffer
    for x := range(s){
        if s[x] == ' '{
            buffer.WriteString("%20")
        }else{
            buffer.WriteByte(s[x])
        }
    }
    return buffer.String()
}