//题意：找出数组中出现次数超过一半的数，没有返回0
//题解：用的map；还可以用候选人法，遇到两个数不一样就消掉，最后还有剩下的就是众数，最后再检验众数是否出现次数足够，空间复杂度更优
package main

/**
 * 
 * @param numbers int整型一维数组 
 * @return int整型
*/
func MoreThanHalfNum_Solution( numbers []int ) int {
    // write code here
    m := make(map[int]int)
    length := len(numbers)
    if length == 0{
        return 0
    }
    length /= 2
    for _,v := range(numbers){
        m[v]++
        if m[v] > length{
            return v
        }
    }
    return 0
}