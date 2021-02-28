//题意：大数加法[字符串加法]
//直接模拟，处理进位
func addStrings(num1 string, num2 string) string {
    add := 0
    ans := ""
    len1,len2 := len(num1),len(num2)
    for i,j := len1-1,len2-1; j>=0 || i>=0 || add != 0;i,j = i-1,j-1{
        x,y := 0,0
        if i >= 0{
            x = int(num1[i] - '0')
        }
        if j >= 0{
            y = int(num2[j] - '0')
        }
        sum := x + y + add
        if sum >= 10{
            add = 1
        }else{
            add = 0
        }
        fmt.Println(sum,add)
        ans = strconv.Itoa(sum%10) + ans
    }
    return ans
}

