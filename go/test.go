package main

import (
    "fmt"
	"strings"
)

func main(){
	str := "wqdqw"
	strs := strings.Split(str,".")
	fmt.Println(strs,len(strs),len(strs[1]))
}

