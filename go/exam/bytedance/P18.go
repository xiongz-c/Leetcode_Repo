package main

import(
    "fmt"
)

func main(){
    var n int
    fmt.Scan(&n)
    for i:=0;i<n;i++{
        var str string
        fmt.Scan(&str)
        length := len(str)
        for j:=0;j<length;j++{
            if j+3>length{
                break
            }
            if str[j]==str[j+1] && str[j+2]==str[j+1]{
                str = str[:j]+str[j+1:]
                length--
                j--
            }else if j+3<length && str[j]==str[j+1] && str[j+3]==str[j+2]{
                str = str[:j+2]+str[j+3:]
                length--
                j--
            }
        }
        fmt.Println(str)
    }
}