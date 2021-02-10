package main

import (
	"container/heap"
	"fmt"
)

type Rectangle struct{
	width int
	height int
}

func ( rec *Rectangle ) Area() int{
	return rec.width * rec.height
}

//定义堆结构体 底层存储为slice
type RectHeap []Rectangle

//实现五个接口[用.访问元素的时候才传指针]
func(rech RectHeap) Len() int{
	return len(rech)
}

func(rech RectHeap) Swap(i,j int){
	rech[i], rech[j] = rech[j], rech[i]
}

func (rech RectHeap) Less(i, j int) bool {
	return rech[i].Area() < rech[j].Area()
}

func(rech *RectHeap) Push(h interface{}) {
	*rech = append(*rech, h.(Rectangle))
}

func(rech *RectHeap) Pop() interface{}{
	// last := len(*rech) - 1
	// res := (*rech)[last]
	// *rech = (*rech)[:last]
	// return res
	n := len(*rech)
	x := (*rech)[n-1]      // 返回删除的元素
	*rech = (*rech)[:n-1] // [n:m]不包括下标为m的元素
	return x
}

func main(){
	hp := &RectHeap{}
	for i := 2; i < 6; i++ {
		*hp = append(*hp, Rectangle{i, i})
	}

	fmt.Println("原始slice: ", hp)

	// 堆操作
	heap.Init(hp)
	heap.Push(hp, Rectangle{100, 10})
	fmt.Println("top元素：", (*hp)[0])
	fmt.Println("删除并返回最后一个：", heap.Pop(hp)) // 最后 一个元素
	fmt.Println("最终slice: ", hp)
}


//比较常用的intheap
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	n := len(*h)-1
	x := (*h)[n]
	*h = (*h)[0 : n]
	return x
}
