//题意：两个数组，交换一个数使得两个数组的和相等，返回两个数组交换出来的数
//题解：用hash存一个数组的值
func fairCandySwap(A []int, B []int) []int {
    sumA,sumB := cntAll(A),cntAll(B)
    delta := (sumA-sumB)>>1
    hash := make(map[int]bool)
    for i,n:=0,len(B);i<n;i++{
        hash[B[i]] = true
    }
    for i,n:=0,len(A);i<n;i++{
        x := A[i] - delta
        if hash[x]{
            return []int{A[i],x}
        }
    }
    return nil
}

func cntAll(arr []int)int{
    length := len(arr)
    sum := 0
    for i:=0;i<length;i++{
        sum += arr[i]
    }
    return sum
}