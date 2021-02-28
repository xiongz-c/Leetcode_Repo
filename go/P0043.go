//题意：大数乘法[字符串乘法]
//题解：模拟乘法过程，在对应位数得到相乘结果，再处理进位问题，最后消除前导0.最快的方法还是FFT快速傅里叶变换

func multiply(num1 string, num2 string) string {
    if num1 == "0" || num2 == "0" {
        return "0"
    }
    m, n := len(num1), len(num2)
    ansArr := make([]int, m + n)
    for i := m - 1; i >= 0; i-- {
        x := int(num1[i]) - '0'
        for j := n - 1; j >= 0; j-- {
            y := int(num2[j] - '0')
            ansArr[i + j + 1] += x * y
        }
    }
    for i := m + n - 1; i > 0; i-- {
        ansArr[i - 1] += ansArr[i] / 10
        ansArr[i] %= 10
    }
    ans := ""
    idx := 0
    for ansArr[idx] == 0 {//消除前导0
        idx++
    }
    for ; idx < m + n; idx++ {
        ans += strconv.Itoa(ansArr[idx])
    }
    return ans
}