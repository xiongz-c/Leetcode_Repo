//题意：【情人节限定】求情侣并排坐最小的交换次数
//题解：标答是并查集，但是简单贪心也能对，无法证明正确性，奇怪的是速度打败了100%。

func minSwapsCouples(row []int) int {
    length := len(row)
    res := 0
    for i:=0;i < length;i+=2{
        if row[i] == row[i+1]^1{
            continue
        }
        for j := i+1;j < length;j++{
            if row[i] == row[j]^1{
                row[i+1],row[j] = row[j],row[i+1]
                break
            }
        }
        res++
    }
    return res
}