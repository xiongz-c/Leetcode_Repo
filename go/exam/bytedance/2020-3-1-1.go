//题意：有一个团队，两两交换礼物，要求随机，并且自己不会拿到自己准备的礼物，请写程序实现
//题解：打乱，链表
package main

import "fmt"
import "math/rand"
import "time"

func main() {
    rand.Seed(time.Now().Unix())
    var num int
    fmt.Scan(&num)
    people := make([]int,num)
    for i:=0;i<num;i++{
        fmt.Scan(&people[i])
    }
    for i:=0;i<num;i++{//swap
        target := rand.Intn(num)
        people[0],people[target] = people[target],people[0]
    }
    for i:=0;i<num;i++{
        if i == 0 {
            fmt.Printf("%v -> %v \n",people[num-1],people[i])
        }else{
            fmt.Printf("%v -> %v \n",people[i-1],people[i])
        }
    }
}