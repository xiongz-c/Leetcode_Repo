//题意：移除k位数字使得数字最小
//题解：贪心+单调栈。需要处理stack为空和前导0的特殊情况
func removeKdigits(num string, k int) string {
    length := len(num)
    stack := make([]byte,0,length)
    for i:=0;i<length;i++{
        if len(stack) == 0{
            stack = push(stack,num[i])
        }else{
            for top(stack) > num[i] && k>0{
                stack = pop(stack)
                k--
            }
            stack = push(stack,num[i])
        }
    }
    for k>0{
        stack = pop(stack)
        k--
    }
    if len(stack) > 0 && stack[0] == '0'{
        for i:=0;i<len(stack);i++{
            if stack[i]!='0'{
                return string(stack[i:])
            }
        }
        return "0"
    }
    if len(stack) == 0{
        return "0"
    }    
    return string(stack)
}

func top(stack []byte)byte{
    if len(stack) == 0{
        return 0
    }
    return stack[len(stack)-1]
}

func pop(stack []byte)[]byte{
    if len(stack) == 0{
        return []byte{}
    }
    stack = stack[:len(stack)-1]
    return stack
}

func push(stack []byte,num byte)[]byte{
    stack = append(stack,num)
    return stack
}