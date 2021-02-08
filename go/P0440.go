//题意：找出0-n之间字典序第k小的数字【字节常考题】
//题解：想象一棵十叉树，通过遍历这棵树找到第k大的值

package main

import(
	"fmt"
)

func main(){
	var n int
	var k int
	fmt.Scanf("%v %v\n",&n,&k)
	fmt.Println(findKthNumber(n,k))
}

func getCnt(prefix int, n int) int{
    cnt := 0
	for a,b:=prefix,prefix+1;a<=n;a,b=a*10,b*10 {
		if n+1<b{
			cnt += n+1 - a
		}else{
			cnt += b - a
		}
	}
	return cnt;
}

func findKthNumber(n int, k int) int {
	prefix, now := 1,1
	for now < k{
		cnt := getCnt(prefix, n)
		if now + cnt > k{// in the subtree of k
			prefix *= 10
			now++ // not root, find in subtree
		}else{// not this subtree
			prefix++
			now += cnt //to next subtree
		}
	}
	return prefix
}