//题意：滑动数组找最值
//题解：单调队列
package main
import "fmt"
/**
 * 
 * @param num int整型一维数组 
 * @param size int整型 
 * @return int整型一维数组
*/
func maxInWindows( num []int ,  size int ) []int {
    // write code here
    length := len(num)
    if size == 0 || size > length{
        return nil
    }
    queue,res := make([]int,0),make([]int,0)
    for i:=0;i<length;i++{
        if len(queue)>0 && queue[0]+size <= i{
            queue = queue[1:]
        }
        for len(queue)>0 && num[queue[len(queue)-1]] < num[i]{
            queue = queue[:len(queue)-1]
        }
        queue = append(queue, i)
        if i >= size-1 {
            res = append(res, num[queue[0]])
        }
        fmt.Println(queue)
    }
    return res
}