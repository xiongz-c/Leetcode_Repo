//题意：读取字符串计算布尔表达式结果
//题解：几个要注意的点：1.标准读入的写法，面试是标准读入。2.计算的时候是压栈，但是go的bool不支持位运算，需要多写点ifelse，注意一些error情况要考虑全

package main

import (
    "fmt"
)

type Foo struct{
    op string
    val bool
}

func main(){
    var strs []string
	for {
		var str string
		n, _ := fmt.Scan(&str)
		if n == 0 {
			break
		}
		strs = append(strs, str)
	}
    fmt.Println(ans(strs))
}

func ans(strs []string) string{
    if len(strs) & 1 == 0 {
        return "error"
    }
    stack := make([]Foo, 0)
    for idx,val := range(strs){
        if idx == 0{
            if val == "true" {
                stack = append(stack,Foo{"and", true})
            }else if val == "false" {
                stack = append(stack,Foo{"and", false})
            }else{
                return "error"
            }
            continue
        }
        if idx & 1 == 0{
            continue
        }
        // idx op, idx+1 val
        switch val{
            case "and":
                if stack[len(stack)-1].val{
                    if strs[idx+1] == "true"{
                        stack[len(stack)-1].val = true
                    }else if strs[idx+1] == "false"{
                        stack[len(stack)-1].val = false
                    }else{
                        return "error"
                    }
                }
            case "or":
                if strs[idx+1] == "true"{
                    stack = append(stack,Foo{"or", true})
                }else if strs[idx+1] == "false"{
                    stack = append(stack,Foo{"or", false})
                }else{
                    return "error"
                }
            default:
                return "error"
        }
    }
    for _,v := range(stack){
        if v.val{
            return "true"
        }
    }
    return "false"
}