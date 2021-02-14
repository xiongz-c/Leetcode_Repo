//题意：构建数组B，B中下标为i的元素是A中除了下标为i的元素的乘积，不能用除法
//题解：for循环
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param A int整型一维数组 
 * @return int整型一维数组
*/
func multiply( A []int ) []int {
    // write code here
    length := len(A)
    B := make([]int, length)
    for i := 0;i < length;i++{
        B[i] = 1
    }
    for i := 0;i < length;i++{
        for j := 0;j < length;j++{
            if i == j{
                continue
            }
            B[j] *= A[i]
        }
    }
    return B
}