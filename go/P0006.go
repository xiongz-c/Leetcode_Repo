//题意：N形打印字符串，输出打印后每一行拼接起来的结果[横向Z形]
//题解：只需要关注行数，明确每一次迭代到第几行，向这一行的列表后面添加元素
func convert(s string, numRows int) string {
    if numRows == 1{
        return s
    }
    ans := make([][]byte, numRows)
    for i:=0;i<numRows;i++{
        ans[i] = make([]byte,0)
    }
    vec,row := false,0
    for i,n:=0,len(s);i<n;i++{
        ans[row] = append(ans[row],s[i])
        if !vec{
            if row < numRows-1{
                row++
            }else{
                vec = !vec
                row--
            }
        }else{
            if row > 0{
                row--
            }else{
                vec = !vec
                row++
            }
        }
    }
    res := ""
    for i:=0;i<numRows;i++{
        res += string(ans[i])
    }
    return res
}