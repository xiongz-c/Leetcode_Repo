package main
/*
注意爆int

*/
import "fmt"



func main(){
	var nums = [] int {1,0,1,0,1,0,0,0,0,0,0}
	fmt.Println(prefixesDivBy5(nums))
}

func prefixesDivBy5(A []int) []bool {
	num := 0
	ans := make([]bool, len(A))
	for i := 0;i < len(A);i++ {// 这里可以换成 for i, v := range a 
		num = num<<1 + A[i]// 加号可以换成 | （或）
		fmt.Printf("i: %d, num: %d\n",i,num)
		num %= 5 
		ans[i] = num == 0
	}
	return ans	
}