//题意：获取字节流中位数
//题解：暴力：每次排序；On：排序改成对应位置插入；Ologn：用以个大顶堆以个小顶堆。这里用go会有比较多冗余代码
package main

import "container/heap"
import "fmt"
 
var minh = newSmallHeap([]int{})
var maxh = newBigHeap([]int{})
func Insert(num int){
    heap.Push(minh,num)
    heap.Push(maxh,heap.Pop(minh))
    if minh.Len()+1<maxh.Len(){
        heap.Push(minh,heap.Pop(maxh))
    }
    fmt.Printf("minh:%+v\t",minh)
    fmt.Printf("maxh:%+v\t",maxh)
}

func GetMedian() float64{
    if minh.Len()<maxh.Len(){
		fmt.Printf(" || get mid -> mid:%v\n",float64((*maxh)[0]))
        return float64((*maxh)[0])
	}
	fmt.Printf(" || get mid -> minh:%v maxh: %v mid:%v\n",(*maxh)[0],(*minh)[0],(float64((*maxh)[0])+float64((*minh)[0]))/2)
    return (float64((*maxh)[0])+float64((*minh)[0]))/2
}

func main(){
	arr := []int{5,2,3,4,1,6,7,0,8}
	for i:=0;i<len(arr);i++{
		Insert(arr[i])
		GetMedian()
	}

}


type smallHeap []int
func(h smallHeap) Len()int{return len(h)}
func(h smallHeap) Less(i,j int)bool{return h[i]<h[j]}
func(h smallHeap) Swap(i,j int){h[i],h[j] = h[j],h[i]}
func(h *smallHeap) Pop()interface{}{
    old := *h
    length := len(old)-1
    num := old[length]
    *h = old[:length]
    return num
}
func(h *smallHeap) Push(x interface{}){
    *h = append(*h, x.(int))
}

func newSmallHeap(v []int) *smallHeap{
    mh := &smallHeap{}
    heap.Init(mh)
    for _,k := range v{
        heap.Push(mh,k)
    }
    return mh
}

type bigHeap []int
func(h bigHeap) Len()int{return len(h)}
func(h bigHeap) Less(i,j int)bool{return h[i]>h[j]}
func(h bigHeap) Swap(i,j int){h[i],h[j] = h[j],h[i]}

func(h *bigHeap) Pop()interface{}{
    old := *h
    length := len(old)-1
    num := old[length]
    *h = old[:length]
    return num
}

func(h *bigHeap) Push(x interface{}){
    *h = append(*h, x.(int))
}

func newBigHeap(v []int) *bigHeap{
    mh := &bigHeap{}
    heap.Init(mh)
    for _,k := range v{
        heap.Push(mh,k)
    }
    return mh
}