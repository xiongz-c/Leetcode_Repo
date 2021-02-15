package main

import (
    "math/rand"
    "time"
    "fmt"
)

func MySort( arr []int ) []int {
    // write code here
    rand.Seed(time.Now().Unix())
    length := len(arr)
    quickSort(arr,0,length-1)
    fmt.Println(arr)
    tmp := make([]int, length)
    mergeSort(arr,tmp,0,length-1)
    fmt.Println(arr)
    return arr
}

func quickSort(arr []int,l,r int){
    if l>=r {
        return
    }
    random := rand.Intn(r-l)+l
    arr[l],arr[random] = arr[random],arr[l]
    m := l
    for i:=l+1;i<=r;i++{
        if arr[i] < arr[l]{
            m++
            arr[i],arr[m] = arr[m],arr[i]
        }
    }
    arr[l],arr[m] = arr[m],arr[l]
    quickSort(arr,l,m-1)
    quickSort(arr,m+1,r)
}


func mergeSort(arr,tmp []int,l,r int){
    if l >= r{return }
    mid := l + ((r-l) >> 1)
    mergeSort(arr,tmp,l,mid)
    mergeSort(arr,tmp,mid+1,r)
    i,j,k := l,mid+1,l
    for i <= mid && j <= r{
        if arr[i] <= arr[j]{
            tmp[k] = arr[i]
            i++
            k++
        }else{
            tmp[k] = arr[j]
            j++
            k++
            //在这里找逆序对，左边的数组剩下的[i,mid]就是逆序的数
        }
    }
    for i <= mid{
        tmp[k] = arr[i]
        i++
        k++
    }
    for j <= r{
        tmp[k] = arr[j]
        j++
        k++
    }
    for beg:=l;beg<=r;beg++{
        arr[beg] = tmp[beg]
    }
}