package main

import (
    "fmt"
)

func main(){
	l:= 1
	for i := 2;i < 1000000;i++{
		if (l + i) / 2 != l + (i-l)/2 {
			fmt.Println(l,i,true)
		}
	}
}

