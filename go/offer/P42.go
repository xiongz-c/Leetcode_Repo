//题意：简单版两数之和
//题解：双指针
package main
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param array int整型一维数组 
 * @param sum int整型 
 * @return int整型一维数组
*/
func FindNumbersWithSum( array []int ,  sum int ) []int {
    // write code here
    length := len(array)
    if length < 2 {
        return nil
    }
    l,r := 0,length-1
    for l < r{
        if array[l] + array[r] > sum{
            r--
        }else if array[l] + array[r] < sum{
            l++
        }else{
            return []int{array[l],array[r]}
        }
    }
    return nil
}