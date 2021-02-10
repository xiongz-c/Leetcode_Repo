//题意：拼接数组里所有的数，打印最小值
//题解：自己重定义一下排序的Less
package main
import(
    "sort"
    "strconv"
    "strings"
)
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param numbers int整型一维数组 
 * @return string字符串
*/

type mystring []string

func ( s mystring ) Len() int{
    return len(s)
}

func ( s mystring ) Swap(i,j int) {
    s[i], s[j] = s[j], s[i]
}

func ( s mystring ) Less(i,j int) bool{
    return comp(s[i],s[j])
}

func comp(str1,str2 string) bool{
    len1,len2 := len(str1),len(str2)
    beg := 0
    for beg < len1 && beg < len2{
        if str1[beg] < str2[beg]{
            return true
        }else if str1[beg] > str2[beg]{
            return false
        }
        beg++
    }
    if len2 > len1{
        return comp(str1,str2[beg:])
    }else if len2 < len1{
        return comp(str1[beg:],str2)
    }
    return true
}

func PrintMinNumber( numbers []int ) string {
    // write code here
    strs := mystring{}
    for _,v := range numbers{
        strs = append(strs,strconv.Itoa(v))
    }
    sort.Sort(strs)
    return strings.Join(strs,"")
}

//上面是自己的实现，比较完整地过了一遍自定义结构体然后重写的过程，下面贴一个牛客上比较简洁的写法，可以把排序的func传进去用
 
func PrintMinNumber( numbers []int ) string {
    // write code here
    sort.Slice(numbers,func(i,j int)bool {
        a,b := strconv.Itoa(numbers[i]),strconv.Itoa(numbers[j])
        return a+b<b+a
    })
    var ans string
    for _,s := range(numbers){
        ans+=strconv.Itoa(s)
    }
    return ans
}