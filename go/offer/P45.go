//题意：判断顺子带癞子
//题解：判断一下有没有重复，没有重复再判断最大最小小于5【其实不用排序】
package main
import "sort"
/**
 * 
 * @param numbers int整型一维数组 
 * @return bool布尔型
*/
func IsContinuous( numbers []int ) bool {
    // write code here
    if len(numbers) != 5{
        return false
    }
    sort.Ints(numbers)
    beg0 := -1
    for beg0 < 4 && numbers[beg0+1] == 0{
        beg0++
    }
    //beg0 is the position of last 0
    var m [15]int
    for i:=beg0+1;i<5;i++{
        m[numbers[i]]++
        if m[numbers[i]]>1{
            return false
        }
    }
    return numbers[4] -  numbers[beg0+1] < 5
}