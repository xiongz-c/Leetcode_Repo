//题意：找到和为目标数的子序列
//题解：滑动窗口，On多一点
package main
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param sum int整型 
 * @return int整型二维数组
*/
func FindContinuousSequence( sum int ) [][]int {
    // write code here
    res := make([][]int,0)
    if sum <= 1{
        return nil
    }
    left,right,tot := 1,2,3
    for right <= sum && left < right{
        if tot < sum {
            right++
            tot += right
        }else if tot > sum{
            tot -= left
            left++
        }else{
            res = append(res,newArr(left,right))
            left++
            right = left+1
            tot = left + right
        }
    }
    return res
}

func newArr(l,r int)[]int{
    res := make([]int,0)
    for l<=r{
        res = append(res,l)
        l++
    }
    return res
}