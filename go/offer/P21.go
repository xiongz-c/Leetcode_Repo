//题意：判断出栈序列是否合法
//题解：开一个栈模拟
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param pushV int整型一维数组 
 * @param popV int整型一维数组 
 * @return bool布尔型
*/
func IsPopOrder( pushV []int ,  popV []int ) bool {
    // write code here
    stack := make([]int,0)
    popIdx := 0
    for _,val := range(pushV){
        stack = append(stack, val)
        for popIdx < len(popV) && len(stack) > 0 && popV[popIdx] == stack[len(stack)-1]{
            stack = stack[:len(stack)-1]
            popIdx++;
        }
    }
    return popIdx == len(popV)
    
}