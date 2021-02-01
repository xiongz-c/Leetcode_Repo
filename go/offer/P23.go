//题意：二叉搜索树的判断
//题解：没要求平衡

package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param sequence int整型一维数组 
 * @return bool布尔型
*/
func VerifySquenceOfBST( sequence []int ) bool {
    // write code here
    if sequence == nil{
        return false
    }
    last := len(sequence)-1
    if last == -1 {
        return false
    }
    return dfs(sequence)
}
func dfs(sequence []int) bool{
    last := len(sequence)-1
    if last < 1{
        return true
    }
    idx := 0
    for idx <= last && sequence[idx] < sequence[last]{
        idx++
    }
    half := idx
    for idx < last{
        if sequence[idx] < sequence[last]{
            return false
        }
        idx++
    }
    return dfs(sequence[:half]) && dfs(sequence[half:last])
}

//没要求平衡
// func dfs(arr []int) bool{
//     length := len(arr)
//     if length == 1 || length == 0{
//         return true
//     }
//     //如果是偶数
//     if length & 1 == 0{
//         for i,n:=0,length/2-1;i<n;i++{
//             if arr[i] > arr[length-1]{
//                 return false
//             }
//         }
//         for i:=length/2;i<length-1;i++{
//             if arr[i] < arr[length-1]{
//                 return false
//             }
//         }
//         if arr[length/2-1] > arr[length-1]{
//             return dfs(arr[length/2-1:length-1]) && dfs(arr[:length/2-1])
//         }else{
//             return dfs(arr[length/2:length-1]) && dfs(arr[:length/2])
//         }
//     }     
//     //数组个数为奇数的时候这样没问题
//     for i,n:=0,length/2;i<n;i++{
//         if arr[i] > arr[length-1]{
//             return false
//         }
//     }
//     for i:=length/2;i<length-1;i++{
//         if arr[i] < arr[length-1]{
//             return false
//         }
//     }
//     return dfs(arr[length/2:length-1]) && dfs(arr[:length/2])
// }