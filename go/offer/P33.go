//题意：定义只含235三个质因子的数为丑数，找到第index个丑数
//题解：又是一道数学题，这里考虑每一个丑数都是前面某个丑数的2/3/5倍，这里需要考虑哪个才是目前最小的（适合跟在后面的），所以维护三个指针确定候选人
package main

/**
 * 
 * @param index int整型 
 * @return int整型
*/
func GetUglyNumber_Solution( index int ) int {
    // write code here
    if index <= 0{
        return 0
    }
    p2,p3,p5:=0,0,0
    ans := make([]int,index)
    ans[0] = 1
    for i:=1;i<index;i++{
        ans[i] = min(ans[p2]*2,min(ans[p3]*3,ans[p5]*5))
        if ans[i] == ans[p2]*2{
            p2++
        }
        if ans[i] == ans[p3]*3{
            p3++
        }
        if ans[i] == ans[p5]*5{
            p5++
        }
    }
    return ans[index-1]
}

func min(i,j int) int{
    if i < j{
        return i
    }
    return j
}