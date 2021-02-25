//题意：返回数组中前k小的数[第k大][第k小]
//题解：排序或者建堆。建堆注意堆的用法push和pop是调用的heap的方法
package main
import (
	"container/heap"
)
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param input int整型一维数组 
 * @param k int整型 
 * @return int整型一维数组
*/

// An IntHeap is a min-heap of ints.
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func GetLeastNumbers_Solution( input []int ,  k int ) []int {
    // write code here
    if k <= 0 || k > len(input) {
        return []int{}
    }
    hp := &IntHeap{}
    *hp = input[:]
    heap.Init(hp)
    res := make([]int,0)
    for i:=0;i<k;i++{
        res = append(res,heap.Pop(hp).(int))
    }
    return res
}