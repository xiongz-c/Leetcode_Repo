//题意：字典序打印字符串数组
//题解：递归打印，注意重复字符的处理和sort的用法
package main

import "sort"
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param str string字符串 
 * @return string字符串一维数组
*/
func Permutation( str string ) []string {
    // write code here
    result := make([]string,0)
    Perm([]rune(str), func(a []rune) {
        result = append(result,string(a))
    })
    sort.Strings(result)
    return result
}

// Perm calls f with each permutation of a.
func Perm(a []rune, f func([]rune)) {
    perm(a, f, 0)
}

// Permute the values at index i to len(a)-1.
func perm(a []rune, f func([]rune), i int) {
    if i > len(a) {
        f(a)
        return
    }
    perm(a, f, i+1)
    for j := i + 1; j < len(a); j++ {
        if a[i] == a[j]{
            continue
        }
        a[i], a[j] = a[j], a[i]
        perm(a, f, i+1)
        a[i], a[j] = a[j], a[i]
    }
}