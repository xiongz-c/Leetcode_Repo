package main

/**
 * 
 * @param array int整型一维数组 
 * @return int整型一维数组
*/
func reOrderArray( array []int ) []int {
    // write code here
    for i:=0;i<len(array);i++{
        j := i 
        for j > 0 && (array[j] & 1) == 1 &&  (array[j-1] & 1) == 0{
            temp := array[j]
            array[j] = array[j-1]
            array[j-1] = temp
            j--
        }
    }
    return array
}