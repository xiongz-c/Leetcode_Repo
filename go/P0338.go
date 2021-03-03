//题意:比特位计数:计算0~num范围中每个数字的二进制中i的个数并全部返回
//题解:dp,有多种dp方式.最简单的是对于一个数x,通过x&x-1得到x最低设置位为0的数y,从而找到dp[x]=dp[y]+1的关系

func countBits(num int) []int {
    ans := make([]int, num+1)
    ans[0] = 0
    for i:= 1;i<len(ans);i++{
        ans[i] = ans[i&(i-1)]+1
    }
    return ans
}