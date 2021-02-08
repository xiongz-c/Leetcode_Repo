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
	last := len(*rech) - 1
	res := (*rech)[last]
	*rech = (*rech)[:last]
	return res
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