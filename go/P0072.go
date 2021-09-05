//题意：编辑距离，求两个字符串之间相差多少次编辑
//题解：dp，遍历

func minDistance(word1 string, word2 string) int {
    len1 := len(word1)
    len2 := len(word2)
    dp := make([][]int, len1+1)
    for i := 0; i < len1 + 1; i++ {
        dp[i] = make([]int, len2+1)
    }
    if len1*len2 == 0{
        if len1 > 0{
            return len1
        }
        return len2
    }
    for i:=0;i<=len1;i++{
        dp[i][0] = i
    }
    for i:=0;i<=len2;i++{
        dp[0][i] = i
    }
    for i:=1;i<=len1;i++{
        for j:=1;j<=len2;j++{
            if word1[i-1] == word2[j-1]{
                dp[i][j] = minThree(dp[i-1][j-1]-1,dp[i-1][j],dp[i][j-1]) + 1
            }else{
                dp[i][j] = minThree(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
            }
            // fmt.Printf("i=%v,j=%v,dp=%v\n",i,j,dp[i][j])
        }
    }
    // fmt.Println(dp)
    return dp[len1][len2]
}

func minThree(a int,b int,c int) int{
    if a < b {
        if a < c{
            return a
        }
    }
    if b < c{
        return b
    }
    return c
}